package top.itodouble.sso.entity.sso;

import top.itodouble.common.Base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import java.util.Date;

/**
 * <p>说明： 用户实体类</P>
 */
@ApiModel("用户")
public class SsoUser extends BaseEntity implements Serializable {

    @ApiModelProperty(name = "name", value = "姓名")
    private String name;

    @ApiModelProperty(name = "code", value = "工号")
    private String code;

    @ApiModelProperty(name = "status", value = "账号状态状态 1正常 2禁用")
    private Integer status;

    @ApiModelProperty(name = "photo", value = "头像")
    private String photo;

    @ApiModelProperty(name = "idNumber", value = "身份证号码")
    private String idNumber;

    @ApiModelProperty(name = "hiredDate", value = "入职日期")
    private Date hiredDate;

    @ApiModelProperty(name = "email", value = "email")
    private String email;

    @ApiModelProperty(name = "mobile", value = "手机号码")
    private String mobile;

    @ApiModelProperty(name = "orderId", value = "排序")
    private Integer orderId;

    @ApiModelProperty(name = "delFlag", value = "是否删除")
    private Integer delFlag;

    @ApiModelProperty(name = "lastLoginIp", value = "")
    private String lastLoginIp;

    @ApiModelProperty(name = "lastLoginTime", value = "")
    private Date lastLoginTime;

    @ApiModelProperty(name = "deptId", value = "所在部门id(以sso_user_job为主)")
    private String deptId;

    @ApiModelProperty(name = "deptCode", value = "")
    private String deptCode;

    @ApiModelProperty(name = "deptName", value = "")
    private String deptName;

    @ApiModelProperty(name = "postId", value = "")
    private String postId;

    @ApiModelProperty(name = "postCode", value = "")
    private String postCode;

    @ApiModelProperty(name = "postName", value = "")
    private String postName;

    public SsoUser() {
    }

    /**
     * get 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * set 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get 工号
     */
    public String getCode() {
        return code;
    }

    /**
     * set 工号
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * get 账号状态状态 1正常 2禁用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * set 账号状态状态 1正常 2禁用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * get 头像
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * set 头像
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * get 身份证号码
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * set 身份证号码
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * get 入职日期
     */
    public Date getHiredDate() {
        return hiredDate;
    }

    /**
     * set 入职日期
     */
    public void setHiredDate(Date hiredDate) {
        this.hiredDate = hiredDate;
    }

    /**
     * get email
     */
    public String getEmail() {
        return email;
    }

    /**
     * set email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * get 手机号码
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * set 手机号码
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * get 排序
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * set 排序
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * get 是否删除
     */
    public Integer getDelFlag() {
        return delFlag;
    }

    /**
     * set 是否删除
     */
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * get 所在部门id(以sso_user_job为主)
     */
    public String getDeptId() {
        return deptId;
    }

    /**
     * set 所在部门id(以sso_user_job为主)
     */
    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }
}
