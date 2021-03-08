package top.itodouble.sso.shiro;

import top.itodouble.common.pojo.CustomException;
import top.itodouble.sso.apiService.SsoRedisServiceApi;
import top.itodouble.sso.apiService.SsoUserApi;
import top.itodouble.sso.constant.FinanceSsoConst;
import top.itodouble.sso.entity.sso.SsoMenu;
import top.itodouble.sso.entity.sso.SsoRole;
import top.itodouble.sso.enums.RedisKeyPrefixEnum;
import top.itodouble.sso.enums.SsoExceptionEnum;
import top.itodouble.sso.pojo.TokenBean;
import top.itodouble.sso.utils.TokenUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.stream.Collectors;

public class JwtRealm extends AuthorizingRealm {
	private Logger logger = LoggerFactory.getLogger(JwtRealm.class);

	@Reference(version = FinanceSsoConst.dubboVersion, interfaceClass = SsoUserApi.class, check = false, timeout = 10000)
	private SsoUserApi ssoUserApi;
	@Reference(version = FinanceSsoConst.dubboVersion, interfaceClass = SsoRedisServiceApi.class, check = false, timeout = 10000)
	private SsoRedisServiceApi ssoRedisServiceApi;


	@Value("${system.code}")
	private String systemCode;

	@Override
	public boolean supports(AuthenticationToken token) {
		return token instanceof OnlyToken;
	}


	/**
	 * 权限 授权
	 *
	 * @param principals
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		logger.error("doGetAuthorizationInfo() =============================================================================");
		String token = (String) principals.getPrimaryPrincipal();
		TokenBean tokenBean = TokenUtils.parseJWT(token);

		List<SsoRole> roleList = ssoUserApi.getUserRoleListWithRedis(tokenBean.getUsername(), tokenBean.getUserId(), systemCode);

		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		if (CollectionUtils.isNotEmpty(roleList)) {
			List<String> roleCodeList = roleList.stream().map(each -> (each.getSystemCode() + "-" + each.getId())).filter(s -> !StringUtils.isEmpty(s)).collect(Collectors.toList());
			simpleAuthorizationInfo.addRoles(roleCodeList);
			List<String> roleIdList = roleList.stream().map(each -> each.getId()).collect(Collectors.toList());

			List<SsoMenu> menuList = ssoUserApi.getUserRoleMenuListWithRedis(tokenBean.getUsername(), roleIdList, tokenBean.getUserId(), systemCode);
			if (CollectionUtils.isNotEmpty(menuList)) {
				simpleAuthorizationInfo.addStringPermissions(menuList.stream().map(each -> each.getPermissionCode()).filter(s -> !StringUtils.isEmpty(s)).collect(Collectors.toList()));
			}
		}
		return simpleAuthorizationInfo;
	}

	/**
	 * 登录 认证
	 *
	 * @param authenticationToken
	 * @return
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken){
		logger.error("doGetAuthenticationInfo() =============================================================================");

		OnlyToken token = (OnlyToken) authenticationToken;

		if (null == token || null == token.getPrincipal()) {
			throw new CustomException(SsoExceptionEnum.UserNameNotExist);
		}
		String tokenStr = token.getPrincipal().toString();
		if (null == tokenStr) {
			tokenStr = token.getPrincipal().toString();
		}
		// 解析token
		TokenBean userBean = TokenUtils.parseJWT(tokenStr);
		if (null == userBean || null == userBean.getUserId()) {
			throw new CustomException(SsoExceptionEnum.UserNameNotExist);
		}
		// 从redis中获取token
		String redisToken = ssoRedisServiceApi.get(RedisKeyPrefixEnum.SsoUserToken.getSn() + userBean.getUsername());

		if (StringUtils.isEmpty(redisToken)) {
			throw new CustomException(SsoExceptionEnum.UserNameNotExist);
		}
		if (!redisToken.equals(tokenStr)) {
			logger.error("redisToken: {}", redisToken);
			logger.error("headerToken: {}", tokenStr);
			throw new CustomException(SsoExceptionEnum.UserNameNotExist);
		}
		ssoRedisServiceApi.authenticationExpire(RedisKeyPrefixEnum.SsoUserToken.getSn() + userBean.getUsername());
		String hex = new SimpleHash(Md5Hash.ALGORITHM_NAME, tokenStr).toHex();
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(tokenStr, hex, getName());
		return authenticationInfo;
	}
}
