package top.itodouble.sso.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel
public class TokenBean implements Serializable {

    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    private String userId;

    /**
     * 用户姓名
     */
    private String name;
    /**
     * 手机号码
     */
    @ApiModelProperty("手机号码")
    private String mobile;
    /**
     * 用户登录IP
     */
    @ApiModelProperty("用户登录IP")
    private String clientIp;
    /**
     * 客户端版本
     */
    @ApiModelProperty("客户端版本")
    private String clientVersion;
    /**
     * 用户角色
     */
    @ApiModelProperty("用户角色")
    private List<String> roleIdList;

    @ApiModelProperty("")
    private String loginName;
    @ApiModelProperty("")
    private String loginPwd;

    public String getUsername() {
        return mobile;
    }

    public void setUsername(String username) {
        this.mobile = username;
    }

    public TokenBean() {
    }

    public TokenBean(String userId, String mobile, String clientIp, String clientVersion, List<String> roleIdList, String loginName, String loginPwd) {
        this.userId = userId;
        this.mobile = mobile;
        this.clientIp = clientIp;
        this.clientVersion = clientVersion;
        this.roleIdList = roleIdList;
        this.loginName = loginName;
        this.loginPwd = loginPwd;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getClientVersion() {
        return clientVersion;
    }

    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
    }

    public List<String> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<String> roleIdList) {
        this.roleIdList = roleIdList;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
