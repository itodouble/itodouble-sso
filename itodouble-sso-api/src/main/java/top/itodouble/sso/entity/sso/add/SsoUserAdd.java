package top.itodouble.sso.entity.sso.add;

import top.itodouble.sso.entity.sso.SsoUser;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class SsoUserAdd extends SsoUser implements Serializable {
    @ApiModelProperty(name = "loginAble", value = "是否允许登录")
    private Integer loginAble;
    @ApiModelProperty(name = "password", value = "密码")
    private String password;

    private Integer enableFlag;
    private String permissionId;

    public Integer getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(Integer enableFlag) {
        this.enableFlag = enableFlag;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public Integer getLoginAble() {
        return loginAble;
    }

    public void setLoginAble(Integer loginAble) {
        this.loginAble = loginAble;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
