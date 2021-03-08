package top.itodouble.sso.entity.sso.add;

import top.itodouble.sso.entity.sso.SsoPermission;

import java.io.Serializable;

public class SsoPermissionAdd extends SsoPermission implements Serializable {
    private String menuName;
    private String roleName;
    private String userName;
    private String createUserName;
    private String updateUserName;

    public SsoPermissionAdd() {
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
