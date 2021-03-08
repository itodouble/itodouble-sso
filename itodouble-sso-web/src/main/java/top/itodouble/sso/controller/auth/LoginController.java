package top.itodouble.sso.controller.auth;

import top.itodouble.common.pojo.RestResult;
import top.itodouble.common.utils.StringUtils;
import top.itodouble.sso.constant.SysConstant;
import top.itodouble.sso.controller.base.BaseController;
import top.itodouble.sso.entity.sso.SsoMenu;
import top.itodouble.sso.entity.sso.SsoRole;
import top.itodouble.sso.entity.sso.add.SsoMenuAdd;
import top.itodouble.sso.entity.sso.add.SsoUserAdd;
import top.itodouble.sso.enums.MenuUrlTypeEnum;
import top.itodouble.sso.enums.RedisKeyPrefixEnum;
import top.itodouble.sso.enums.SsoUserStatusEnum;
import top.itodouble.sso.pojo.TokenBean;
import top.itodouble.sso.pojo.UserPojo;
import top.itodouble.sso.service.SsoRedisService;
import top.itodouble.sso.service.add.SsoUserAddService;
import top.itodouble.sso.utils.SecurityUtils;
import top.itodouble.sso.utils.TokenUtils;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 登录
 */
@RestController
@RequestMapping(value = "/auth")
public class LoginController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private SsoUserAddService ssoUserAddService;
	@Autowired
	private SsoRedisService ssoRedisService;
	@Value("${system.code}")
	private String systemCode;
	@Value("${finance.sso.domain}")
	private String domains;

	/**
	 * 执行登录
	 *
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 */
	@PostMapping(value = "/login")
	public RestResult login(HttpServletRequest request, HttpServletResponse response, @RequestBody UserPojo user) throws InvocationTargetException, IllegalAccessException {
		if (StringUtils.isNotNull(user.getUsername()) && StringUtils.isNotNull(user.getPassword())) {
			String loginSystemCode = user.getSystemCode();
			if (StringUtils.isEmpty(loginSystemCode)) {
				loginSystemCode = systemCode;
			}
			SsoUserAdd ssoUser = ssoUserAddService.selectByMobileOrCodeWithPassword(user.getUsername());
			String token = ssoRedisService.get(RedisKeyPrefixEnum.SsoUserToken.getSn() + ssoUser.getMobile());
			Map<String, Object> res = new HashMap<>();
			ssoUserAddService.insertLoginHistory(ssoUser, request, response);
			if (null == ssoUser) {
				return RestResult.error().message("用户名或密码错误!");
			}
			if (!user.getPassword().equals(ssoUser.getPassword())) {
				return RestResult.error().message("用户名或密码错误!");
			}
			if (!SsoUserStatusEnum.enable(ssoUser.getStatus())) {
				return RestResult.error().message("账号不可用!");
			}
			TokenBean tokenBean;
			if (StringUtils.isNotNull(token)) {
				tokenBean = TokenUtils.parseJWT(token);
			} else {
				// 生成token
				tokenBean = new TokenBean();
				tokenBean.setUserId(ssoUser.getId());
				tokenBean.setMobile(ssoUser.getMobile());
				// .claim("clientIp", tokenBean.getClientIp())
				// .claim("clientVersion", tokenBean.getClientVersion())
				tokenBean.setName(ssoUser.getName());
				token = TokenUtils.createJwtToken(tokenBean);
				ssoRedisService.setAndCheckExpireFlag(RedisKeyPrefixEnum.SsoUserToken.getSn() + ssoUser.getMobile(), token);
			}

			res.put("token", token);
			res.put("tokenBean", tokenBean);

			setDomainsCookies(response, token);

			// 登录后缓存按钮权限信息
			List<SsoRole> roleList = ssoUserAddService.getUserRoleList(tokenBean.getUsername(), tokenBean.getUserId(), loginSystemCode);
			res.put("roleList", roleList);
			if (CollectionUtils.isNotEmpty(roleList)) {
				List<String> roleIdList = roleList.stream().map(each -> each.getId()).collect(Collectors.toList());
				List<SsoMenu> menuList = ssoUserAddService.getUserRoleMenuList(tokenBean.getUsername(), roleIdList, tokenBean.getUserId(), loginSystemCode);
				if(CollectionUtils.isNotEmpty(menuList)) {
					List<SsoMenu> frontMenuList = menuList.stream().filter(each -> MenuUrlTypeEnum.Menu.getSnData().equals(each.getUrlType())).collect(Collectors.toList());
					Map<String, SsoMenu> buttonMenuMap = menuList.stream()
							.filter(each -> MenuUrlTypeEnum.Button.getSnData().equals(each.getUrlType()))
							.collect(Collectors.toMap(SsoMenu::getPermissionCode, SsoMenu -> SsoMenu));
					List<SsoMenuAdd> menuTree = ssoUserAddService.menuListToTree(frontMenuList);
					res.put("menuList", menuTree);
					res.put("buttonMenuMap", buttonMenuMap);
				}
			}
			return RestResult.success().data(res);
		}
		return RestResult.error().message("用户名或密码为空!");
	}

	@PostMapping(value = "/userinfo")
	public RestResult userinfo(){
		TokenBean tokenBean = SecurityUtils.getTokenBean();

		return RestResult.success();
	}


	@RequestMapping(value = "/logout")
	public RestResult logout(HttpServletRequest request, HttpServletResponse response) {
		try {
			TokenBean tokenBean = SecurityUtils.getTokenBean();
			if (null != tokenBean && StringUtils.isNotNull(tokenBean.getUsername())) {
				ssoRedisService.delUserInfo(tokenBean.getUsername());
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return RestResult.success();
	}

	@PostMapping(value = "/roles")
	public RestResult roles(@RequestBody Map param) {
		Map res = new HashMap();
		TokenBean tokenBean = SecurityUtils.getTokenBean();
		String loginSystemCode = StringUtils.toString(param.get("systemCode"));
		if (StringUtils.isEmpty(loginSystemCode)) {
			loginSystemCode = systemCode;
		}
		List<SsoRole> roleList = ssoUserAddService.getUserRoleListWithRedis(tokenBean.getUsername(), tokenBean.getUserId(), loginSystemCode);
		res.put("roleList", roleList);
		return RestResult.success().data(res);

	}

	/**
	 * 获取前端菜单
	 *
	 * @param
	 * @return
	 */
	@PostMapping(value = "/menus")
	public RestResult menus(@RequestBody Map param) throws InvocationTargetException, IllegalAccessException {
		Map res = new HashMap();
		TokenBean tokenBean = SecurityUtils.getTokenBean();
		String loginSystemCode = StringUtils.toString(param.get("systemCode"));
		if (StringUtils.isEmpty(loginSystemCode)) {
			loginSystemCode = systemCode;
		}
		List<SsoMenu> menuList = ssoUserAddService.getUserRoleMenuList(tokenBean.getUsername(), tokenBean.getUserId(), loginSystemCode);
		if (CollectionUtils.isNotEmpty(menuList)) {
			if (StringUtils.isNotNull(loginSystemCode)) {
				List<SsoMenu> frontMenuList = menuList.stream().filter(each -> MenuUrlTypeEnum.Menu.getSnData().equals(each.getUrlType())).collect(Collectors.toList());
				Map<String, SsoMenu> buttonMenuMap = menuList.stream()
						.filter(each -> MenuUrlTypeEnum.Button.getSnData().equals(each.getUrlType()))
						.collect(Collectors.toMap(SsoMenu::getPermissionCode, SsoMenu -> SsoMenu));
				List<SsoMenuAdd> menuTree = ssoUserAddService.menuListToTree(frontMenuList);
				res.put("menuList", menuTree);
				res.put("buttonMenuMap", buttonMenuMap);

				return RestResult.success().data(res);
			}
		}
		return RestResult.error().data(null);
	}

	private void setDomainsCookies(HttpServletResponse response, String token){
		try {
			if (StringUtils.isNotNull(domains)) {
				Arrays.stream(domains.split(",")).forEach(each->{
					String cookieVal = SysConstant.TOKEN_NAME+"="+token+";Path=/;Domain=."+each+";Max-Age=9999999;HTTPOnly";
					response.setHeader("Set-Cookie", cookieVal);
				});
			}
		} catch (Exception e) {
		    logger.error(e.getMessage(), e);
		}

	}
}
