package top.itodouble.sso.mapper.sso.add;

import top.itodouble.sso.entity.sso.SsoMenu;

import java.util.List;
import java.util.Map;

public interface SsoMenuAddMapper {
	/**
	 * 查询角色和用户拥有菜单
	 * @param param roleIds,userId,systemCode
	 * @return
	 */
	List<SsoMenu> getUserRoleMenuList(Map param);
}
