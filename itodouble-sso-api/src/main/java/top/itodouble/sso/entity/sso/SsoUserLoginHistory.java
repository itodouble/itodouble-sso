package top.itodouble.sso.entity.sso;

import top.itodouble.common.Base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import java.util.Date;

/**
 * <p>说明： 登录历史实体类</P>
 */
@ApiModel("登录历史")
public class SsoUserLoginHistory extends BaseEntity implements Serializable {

    @ApiModelProperty(name = "loginIp", value = "登录IP")
    private String loginIp;

    @ApiModelProperty(name = "loginTime", value = "登录时间")
    private Date loginTime;

    @ApiModelProperty(name = "device", value = "设备")
    private String device;

    public SsoUserLoginHistory() {
    }

    /**
     * get 登录IP
     */
    public String getLoginIp() {
        return loginIp;
    }

    /**
     * set 登录IP
     */
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    /**
     * get 登录时间
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * set 登录时间
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * get 设备
     */
    public String getDevice() {
        return device;
    }

    /**
     * set 设备
     */
    public void setDevice(String device) {
        this.device = device;
    }
}
