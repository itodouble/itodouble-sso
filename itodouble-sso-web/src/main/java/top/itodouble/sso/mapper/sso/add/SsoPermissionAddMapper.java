package top.itodouble.sso.mapper.sso.add;

import top.itodouble.sso.entity.sso.add.SsoMenuAdd;
import top.itodouble.sso.entity.sso.add.SsoPermissionAdd;
import top.itodouble.sso.entity.sso.add.SsoUserAdd;

import java.util.List;
import java.util.Map;

public interface SsoPermissionAddMapper {

	/**
	 * systemCode 系统代码
	 * parentId 父级菜单
	 * enableFlag 是否启用
	 * @param param
	 * @return
	 */
	List<SsoMenuAdd> menuRoleLeft(Map param);

	List<SsoPermissionAdd> list(Map param);

	/**
	 * 角色->用户列表分页
	 * roleId
	 * @param param
	 * @return
	 */
	List<SsoUserAdd> userRoleList(Map param);
}
