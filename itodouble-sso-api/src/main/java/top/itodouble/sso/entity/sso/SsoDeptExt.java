package top.itodouble.sso.entity.sso;

import top.itodouble.common.Base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>说明： 部门扩展表实体类</P>
 */
@ApiModel("部门扩展表")
public class SsoDeptExt extends BaseEntity implements Serializable {

    @ApiModelProperty(name = "deptId", value = "")
    private String deptId;

    @ApiModelProperty(name = "deptHeadUserId", value = "")
    private String deptHeadUserId;

    @ApiModelProperty(name = "deptHeadName", value = "部门负责人姓名")
    private String deptHeadName;

    @ApiModelProperty(name = "deptHeadMobile", value = "部门负责人手机号码")
    private String deptHeadMobile;

    @ApiModelProperty(name = "socialCreditCode", value = "统一社会信用代码")
    private String socialCreditCode;

    @ApiModelProperty(name = "registeredAddress", value = "公司注册地址")
    private String registeredAddress;

    @ApiModelProperty(name = "deptOptName", value = "实际操作人姓名")
    private String deptOptName;

    @ApiModelProperty(name = "deptOptMobile", value = "实际操作人手机号码")
    private String deptOptMobile;

    @ApiModelProperty(name = "workPlace", value = "工作地点")
    private String workPlace;

    @ApiModelProperty(name = "deptAddressProvince", value = "门店地址/部门地址 省")
    private String deptAddressProvince;

    @ApiModelProperty(name = "deptAddressCity", value = "门店地址/部门地址 市")
    private String deptAddressCity;

    @ApiModelProperty(name = "deptAddressArea", value = "门店地址/部门地址 区")
    private String deptAddressArea;

    @ApiModelProperty(name = "deptAddressDetail", value = "门店地址/部门地址 详细信息")
    private String deptAddressDetail;

    public SsoDeptExt() {
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptHeadUserId() {
        return deptHeadUserId;
    }

    public void setDeptHeadUserId(String deptHeadUserId) {
        this.deptHeadUserId = deptHeadUserId;
    }

    /**
     * get 部门负责人姓名
     */
    public String getDeptHeadName() {
        return deptHeadName;
    }

    /**
     * set 部门负责人姓名
     */
    public void setDeptHeadName(String deptHeadName) {
        this.deptHeadName = deptHeadName;
    }

    /**
     * get 部门负责人手机号码
     */
    public String getDeptHeadMobile() {
        return deptHeadMobile;
    }

    /**
     * set 部门负责人手机号码
     */
    public void setDeptHeadMobile(String deptHeadMobile) {
        this.deptHeadMobile = deptHeadMobile;
    }

    /**
     * get 统一社会信用代码
     */
    public String getSocialCreditCode() {
        return socialCreditCode;
    }

    /**
     * set 统一社会信用代码
     */
    public void setSocialCreditCode(String socialCreditCode) {
        this.socialCreditCode = socialCreditCode;
    }

    /**
     * get 公司注册地址
     */
    public String getRegisteredAddress() {
        return registeredAddress;
    }

    /**
     * set 公司注册地址
     */
    public void setRegisteredAddress(String registeredAddress) {
        this.registeredAddress = registeredAddress;
    }

    /**
     * get 实际操作人姓名
     */
    public String getDeptOptName() {
        return deptOptName;
    }

    /**
     * set 实际操作人姓名
     */
    public void setDeptOptName(String deptOptName) {
        this.deptOptName = deptOptName;
    }

    /**
     * get 实际操作人手机号码
     */
    public String getDeptOptMobile() {
        return deptOptMobile;
    }

    /**
     * set 实际操作人手机号码
     */
    public void setDeptOptMobile(String deptOptMobile) {
        this.deptOptMobile = deptOptMobile;
    }

    /**
     * get 工作地点
     */
    public String getWorkPlace() {
        return workPlace;
    }

    /**
     * set 工作地点
     */
    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    /**
     * get 门店地址/部门地址 省
     */
    public String getDeptAddressProvince() {
        return deptAddressProvince;
    }

    /**
     * set 门店地址/部门地址 省
     */
    public void setDeptAddressProvince(String deptAddressProvince) {
        this.deptAddressProvince = deptAddressProvince;
    }

    /**
     * get 门店地址/部门地址 市
     */
    public String getDeptAddressCity() {
        return deptAddressCity;
    }

    /**
     * set 门店地址/部门地址 市
     */
    public void setDeptAddressCity(String deptAddressCity) {
        this.deptAddressCity = deptAddressCity;
    }

    /**
     * get 门店地址/部门地址 区
     */
    public String getDeptAddressArea() {
        return deptAddressArea;
    }

    /**
     * set 门店地址/部门地址 区
     */
    public void setDeptAddressArea(String deptAddressArea) {
        this.deptAddressArea = deptAddressArea;
    }

    /**
     * get 门店地址/部门地址 详细信息
     */
    public String getDeptAddressDetail() {
        return deptAddressDetail;
    }

    /**
     * set 门店地址/部门地址 详细信息
     */
    public void setDeptAddressDetail(String deptAddressDetail) {
        this.deptAddressDetail = deptAddressDetail;
    }
}
