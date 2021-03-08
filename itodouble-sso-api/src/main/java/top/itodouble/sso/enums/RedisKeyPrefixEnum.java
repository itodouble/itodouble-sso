package top.itodouble.sso.enums;

import top.itodouble.common.Base.BaseEnum;

/**
 * redis 缓存前缀
 */
public enum RedisKeyPrefixEnum implements BaseEnum {
    SsoUserToken("sso_user_token_", "用户账号信息(token)"),
    SsoUserInfo("sso_user_info_", "用户信息"),
    /**
     * 用户某个系统拥有的角色
     * Map<String, List<SsoRole>> key 系统code
     */
    SsoSystemUserRole("sso_system_user_role_", "用户某个系统拥有的角色"),
    SsoSystemUserMenu("sso_system_user_menu_", "用户某个系统拥有的菜单"),

    SsoSystemRole("sso_system_role_", "某个系统拥有的全部角色"),
    SsoSystemMenu("sso_system_menu_", "某个系统拥有的全部菜单");


    RedisKeyPrefixEnum(String sn, String snDesc) {
        this.sn = sn;
        this.snDesc = snDesc;
    }

    private String sn;
    private String snDesc;

    @Override
    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    @Override
    public String getSnDesc() {
        return snDesc;
    }

    public void setSnDesc(String snDesc) {
        this.snDesc = snDesc;
    }

    @Override
    public Object getSnData() {
        return sn;
    }

}
