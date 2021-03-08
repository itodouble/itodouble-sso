package top.itodouble.sso.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 登录用户封装
 */
@ApiModel(description = "登录用户封装")
public class UserPojo implements Serializable {
    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String username;
    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;
    /**
     * 登录设备
     */
    @ApiModelProperty("登录设备")
    private String device;
    /**
     * 版本号
     */
    @ApiModelProperty("版本号")
    private String version;

    /**
     * 系统代码
     */
    @ApiModelProperty("系统代码")
    private String systemCode;

    public UserPojo() {
    }

    public UserPojo(String username, String password, String device, String version) {
        this.username = username;
        this.password = password;
        this.device = device;
        this.version = version;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }
}
