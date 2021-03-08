package top.itodouble.sso.entity.sso;

import top.itodouble.common.Base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>说明： 用户第三方平台信息实体类</P>
 */
@ApiModel("用户第三方平台信息")
public class SsoUserThirdParty extends BaseEntity implements Serializable {

    @ApiModelProperty(name = "userId", value = "用户id")
    private String userId;

    @ApiModelProperty(name = "appId", value = "第三方平台 appid")
    private String appId;

    @ApiModelProperty(name = "enableFlag", value = "是否启用(可用)")
    private Integer enableFlag;

    @ApiModelProperty(name = "appUserId", value = "对应第三方平台user_id")
    private String appUserId;

    @ApiModelProperty(name = "appUnionId", value = "第三方unionId")
    private String appUnionId;

    @ApiModelProperty(name = "appOpenId", value = "第三方open_id")
    private String appOpenId;

    public SsoUserThirdParty() {
    }

    /**
     * get 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * set 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * get 第三方平台 appid
     */
    public String getAppId() {
        return appId;
    }

    /**
     * set 第三方平台 appid
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * get 是否启用(可用)
     */
    public Integer getEnableFlag() {
        return enableFlag;
    }

    /**
     * set 是否启用(可用)
     */
    public void setEnableFlag(Integer enableFlag) {
        this.enableFlag = enableFlag;
    }

    /**
     * get 对应第三方平台user_id
     */
    public String getAppUserId() {
        return appUserId;
    }

    /**
     * set 对应第三方平台user_id
     */
    public void setAppUserId(String appUserId) {
        this.appUserId = appUserId;
    }

    /**
     * get 第三方unionId
     */
    public String getAppUnionId() {
        return appUnionId;
    }

    /**
     * set 第三方unionId
     */
    public void setAppUnionId(String appUnionId) {
        this.appUnionId = appUnionId;
    }

    /**
     * get 第三方open_id
     */
    public String getAppOpenId() {
        return appOpenId;
    }

    /**
     * set 第三方open_id
     */
    public void setAppOpenId(String appOpenId) {
        this.appOpenId = appOpenId;
    }
}
