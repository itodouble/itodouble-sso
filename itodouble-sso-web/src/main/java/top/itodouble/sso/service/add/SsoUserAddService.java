package top.itodouble.sso.service.add;

import com.alibaba.fastjson.JSONObject;
import top.itodouble.common.utils.JsonUtils;
import top.itodouble.common.utils.StringUtils;
import top.itodouble.sso.entity.sso.SsoMenu;
import top.itodouble.sso.entity.sso.SsoRole;
import top.itodouble.sso.entity.sso.SsoUser;
import top.itodouble.sso.entity.sso.SsoUserLoginHistory;
import top.itodouble.sso.entity.sso.add.SsoMenuAdd;
import top.itodouble.sso.entity.sso.add.SsoUserAdd;
import top.itodouble.sso.enums.MenuUrlTypeEnum;
import top.itodouble.sso.enums.RedisKeyPrefixEnum;
import top.itodouble.sso.mapper.sso.SsoUserLoginHistoryMapper;
import top.itodouble.sso.mapper.sso.SsoUserMapper;
import top.itodouble.sso.mapper.sso.add.SsoMenuAddMapper;
import top.itodouble.sso.mapper.sso.add.SsoRoleAddMapper;
import top.itodouble.sso.mapper.sso.add.SsoUserAddMapper;
import top.itodouble.sso.service.SsoRedisService;
import top.itodouble.sso.utils.WebUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SsoUserAddService {
	@Autowired
	private SsoUserMapper ssoUserMapper;
	@Autowired
	private SsoUserAddMapper ssoUserAddMapper;
	@Autowired
	private SsoRoleAddMapper ssoRoleAddMapper;
	@Autowired
	private SsoMenuAddMapper ssoMenuAddMapper;
	@Autowired
	private SsoUserLoginHistoryMapper ssoUserLoginHistoryMapper;
	@Autowired
	private SsoRedisService ssoRedisService;

	@Value("${shiro.token.access.expire.redisFlag}")
	private Boolean accessTokenExpireRedisFlag;
	@Value("${shiro.token.access.expire.redisTime}")
	private Long accessTokenExpireRedisTime;

	/**
	 * 根据手机号码或工号获取用户信息
	 *
	 * @param keyword
	 * @return
	 */
	public SsoUserAdd selectByMobileOrCodeWithPassword(String keyword) {
		return ssoUserAddMapper.selectByMobileOrCodeWithPassword(keyword);
	}

	public SsoUser selectByMobileOrCode(String keyword) {
		return ssoUserAddMapper.selectByMobileOrCode(keyword);
	}

	/**
	 * 根据用户id获取用户拥有角色
	 *
	 * @param
	 * @return
	 */
	public List<SsoRole> getUserRoleList(String userId) {
		Map map = new HashMap();
		map.put("userId", userId);
		return ssoRoleAddMapper.getUserRoleList(map);
	}

	/**
	 * 获取用户在该系统中拥有的角色列表
	 *
	 * @param username
	 * @param userId
	 * @param systemCode
	 * @return
	 */
	public List<SsoRole> getUserRoleList(String username, String userId, String systemCode) {
		List<SsoRole> allRoleList = getUserRoleList(userId);
		if (CollectionUtils.isNotEmpty(allRoleList)) {
			Map<String, List<SsoRole>> userRoleSystemMap = allRoleList.stream().collect(Collectors.groupingBy(SsoRole::getSystemCode));
			ssoRedisService.setAndCheckExpireFlag(RedisKeyPrefixEnum.SsoSystemUserRole.getSn() + username, JsonUtils.beanToString(userRoleSystemMap));
			return userRoleSystemMap.get(systemCode);
		}
		return null;
	}

	public List<SsoRole> getUserRoleListByUserIdWithRedis(String userId, String systemCode) {
		SsoUser ssoUser = ssoUserMapper.selectByPrimaryKey(userId);
		if (null != ssoUser) {
			return getUserRoleListWithRedis(ssoUser.getMobile(), ssoUser.getId(), systemCode);
		}
		return null;
	}

	/**
	 * 用户拥有角色 先从缓存中获取 如果没有再去数据库
	 *
	 * @param userId
	 * @param systemCode
	 * @return
	 */
	public List<SsoRole> getUserRoleListWithRedis(String username, String userId, String systemCode) {
		String jsonStr = ssoRedisService.get(RedisKeyPrefixEnum.SsoSystemUserRole.getSn() + username);
		if (StringUtils.isNotNull(jsonStr)) {
			JSONObject jsonObject = JSONObject.parseObject(jsonStr);
			if (null != jsonObject) {
				return jsonObject.getJSONArray(systemCode).toJavaList(SsoRole.class);
			}
		}
		return getUserRoleList(username, userId, systemCode);
	}

	public List<SsoRole> getUserRoleListWithRedis(String username, String systemCode) {
		String jsonStr = ssoRedisService.get(RedisKeyPrefixEnum.SsoSystemUserRole.getSn() + username);
		if (StringUtils.isNotNull(jsonStr)) {
			JSONObject jsonObject = JSONObject.parseObject(jsonStr);
			if (null != jsonObject) {
				return jsonObject.getJSONArray(systemCode).toJavaList(SsoRole.class);
			}
		}
		SsoUser ssoUser = ssoUserAddMapper.selectByMobileOrCode(username);
		if (null != ssoUser) {
			return getUserRoleList(username, ssoUser.getId(), systemCode);
		}
		return null;
	}

	/**
	 * 获取角色,用户 拥有的菜单
	 *
	 * @param roleIdList
	 * @param userId
	 * @return
	 */
	public List<SsoMenu> getUserRoleMenuList(List<String> roleIdList, String userId, String systemCode) {
		Map param = new HashMap();
		param.put("roleIds", roleIdList);
		param.put("userId", userId);
		param.put("systemCode", systemCode);
		return ssoMenuAddMapper.getUserRoleMenuList(param);
	}

	/**
	 * 从redis中获取存放的权限菜单
	 * @param username
	 * @param systemCode
	 * @return
	 */
	public List<SsoMenu> getUserRoleMenuListFromRedis(String username, String systemCode) {
		String jsonStr = ssoRedisService.get(RedisKeyPrefixEnum.SsoSystemUserMenu.getSn() + username);
		if (StringUtils.isNotNull(jsonStr)) {
			JSONObject jsonObject = JSONObject.parseObject(jsonStr);
			if (null != jsonObject) {
				return jsonObject.getJSONArray(systemCode).toJavaList(SsoMenu.class);
			}
		}
		return null;
	}

	/**
	 * 用户拥有菜单 先从缓存中获取 如果没有再去数据库
	 *
	 * @param username
	 * @param roleIdList
	 * @param userId
	 * @param systemCode
	 * @return
	 */
	public List<SsoMenu> getUserRoleMenuListWithRedis(String username, List<String> roleIdList, String userId, String systemCode) {
		List<SsoMenu> list = getUserRoleMenuListFromRedis(username, systemCode);
		if (CollectionUtils.isEmpty(list)) {
			return getUserRoleMenuList(username, roleIdList, userId, systemCode);
		}
		return list;
	}
	public List<SsoMenu> getUserRoleMenuList(String username, List<String> roleIdList, String userId, String systemCode) {
		List<SsoMenu> allMenuList = getUserRoleMenuList(roleIdList, userId, null);
		if (CollectionUtils.isNotEmpty(allMenuList)) {
			Map<String, List<SsoMenu>> userMenuSystemMap = allMenuList.stream().collect(Collectors.groupingBy(SsoMenu::getSystemCode));
			ssoRedisService.setAndCheckExpireFlag(RedisKeyPrefixEnum.SsoSystemUserMenu.getSn() + username, JsonUtils.beanToString(userMenuSystemMap));
			return userMenuSystemMap.get(systemCode);
		}
		return null;
	}

	public List<SsoMenu> getUserRoleMenuList(String username, String userId, String systemCode) {
		List<SsoRole> roleList = getUserRoleList(username, userId, systemCode);
		if (CollectionUtils.isNotEmpty(roleList)) {
			List<String> roleIdList = roleList.stream().map(each->each.getId()).collect(Collectors.toList());
			List<SsoMenu> allMenuList = getUserRoleMenuList(roleIdList, userId, null);
			if (CollectionUtils.isNotEmpty(allMenuList)) {
				Map<String, List<SsoMenu>> userMenuSystemMap = allMenuList.stream().collect(Collectors.groupingBy(SsoMenu::getSystemCode));
				ssoRedisService.setAndCheckExpireFlag(RedisKeyPrefixEnum.SsoSystemUserMenu.getSn() + username, JsonUtils.beanToString(userMenuSystemMap));
				return userMenuSystemMap.get(systemCode);
			}
		}
		return null;
	}

	public List<SsoMenu> getUserRoleMenuListWithRedis(String username, String systemCode) {
		List<SsoMenu> list = getUserRoleMenuListFromRedis(username, systemCode);
		if (CollectionUtils.isNotEmpty(list)) {
			return list;
		}
		SsoUser ssoUser = ssoUserAddMapper.selectByMobileOrCode(username);
		if (null != ssoUser) {
			List<SsoRole> roleList = getUserRoleList(ssoUser.getId());
			List<String> roleIdList = null;
			if (CollectionUtils.isNotEmpty(roleList)) {
				roleIdList = roleList.stream().map(SsoRole::getId).collect(Collectors.toList());
			}
			return getUserRoleMenuList(username, roleIdList, ssoUser.getId(), systemCode);
		}

		return null;
	}

	public List<SsoMenuAdd> menuListToTree(List<SsoMenu> list) throws InvocationTargetException, IllegalAccessException {
		List<SsoMenuAdd> treeList = new ArrayList<>();
		List<SsoMenu> menuListTmp = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			SsoMenu each = list.get(i);
			if (each.getUrlType() == MenuUrlTypeEnum.Menu.getSnData()) {
				if (!StringUtils.isNotNull(each.getParentId()) || each.getParentId().equals("0")) {
					SsoMenuAdd item = new SsoMenuAdd();
					BeanUtils.copyProperties(item, each);
					treeList.add(item);
				} else {
					menuListTmp.add(each);
				}
			}
		}
		menuListToTreeSub(menuListTmp, treeList);
		return treeList;
	}

	private List<SsoMenuAdd> menuListToTreeSub(List<SsoMenu> list, List<SsoMenuAdd> treeList) throws InvocationTargetException, IllegalAccessException {
		if (CollectionUtils.isNotEmpty(treeList)) {
			for (int i = 0; i < treeList.size(); i++) {
				for (int j = 0; j < list.size(); j++) {
					if (treeList.get(i).getId().equals(list.get(j).getParentId())) {

						SsoMenuAdd item = new SsoMenuAdd();
						BeanUtils.copyProperties(item, list.get(j));
						if (null == treeList.get(i).getChildren()) {
							treeList.get(i).setChildren(new ArrayList<>());
						}
						treeList.get(i).getChildren().add(item);
					}
				}
				if (CollectionUtils.isNotEmpty(list)) {
					this.menuListToTreeSub(list, treeList.get(i).getChildren());
				}
			}
		}
		return treeList;
	}

	public int insertLoginHistory(SsoUser ssoUser, HttpServletRequest request, HttpServletResponse servletResponse) {
		SsoUserLoginHistory ssoUserLoginHistory = new SsoUserLoginHistory();
		ssoUserLoginHistory.setLoginIp(WebUtils.getIpAddr(request));
		ssoUserLoginHistory.setLoginTime(new Date());
		ssoUserLoginHistory.setDevice(request.getHeader("user-agent"));
		return ssoUserLoginHistoryMapper.insertSelective(ssoUserLoginHistory);
	}

	public Map<String, String> selectUserName(List<String> userId) {
		return ssoUserAddMapper.selectUserName(userId);
	}

	public List<Map<String, String>> selectUserListByKeyword(Map param) {
		Integer count = ssoUserAddMapper.selectUserListByKeywordCount(param);
		if (null != count && count > 500) {
			param.put("limitStr", "limit 100");
		}
		return ssoUserAddMapper.selectUserListByKeyword(param);
	}
}
