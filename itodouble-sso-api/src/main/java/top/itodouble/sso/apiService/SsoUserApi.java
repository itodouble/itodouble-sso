package top.itodouble.sso.apiService;

import top.itodouble.sso.entity.sso.SsoMenu;
import top.itodouble.sso.entity.sso.SsoRole;
import top.itodouble.sso.entity.sso.SsoUser;

import java.util.List;

public interface SsoUserApi {
    /**
     * 获取该用户在某个系统中的角色列表
     *
     * @param userId
     * @param systemCode
     * @return
     */
    List<SsoRole> getUserRoleListByUserIdWithRedis(String userId, String systemCode);

    /**
     * 获取该用户在某个系统中的角色列表
     *
     * @param username   用户名或手机号码
     * @param userId     用户id（如果redis中不存在从数据库获取）
     * @param systemCode 系统代码
     * @return
     */
    List<SsoRole> getUserRoleListWithRedis(String username, String userId, String systemCode);

    /**
     * 获取该用户在某个系统中的角色列表
     *
     * @param username   用户名或手机号码
     * @param systemCode 系统代码
     * @return
     */
    List<SsoRole> getUserRoleListWithRedis(String username, String systemCode);

    /**
     * 获取该用户在某个系统中的菜单权限列表
     *
     * @param username
     * @param roleIdList
     * @param userId
     * @param systemCode
     * @return
     */
    List<SsoMenu> getUserRoleMenuListWithRedis(String username, List<String> roleIdList, String userId, String systemCode);

    /**
     * 获取该用户在某个系统中的菜单权限列表
     *
     * @param username
     * @param systemCode
     * @return
     */
    List<SsoMenu> getUserRoleMenuListWithRedis(String username, String systemCode);

    /**
     * 根据id获取用户信息
     *
     * @param userId
     * @return
     */
    SsoUser getUserById(String userId);
}
