package top.itodouble.sso.entity.sso;

import top.itodouble.common.Base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import java.util.Date;

/**
 * <p>说明： 部门实体类</P>
 */
@ApiModel("部门")
public class SsoDept extends BaseEntity implements Serializable {

    @ApiModelProperty(name = "orgId", value = "公司id")
    private String orgId;

    @ApiModelProperty(name = "name", value = "部门(公司)名称")
    private String name;

    @ApiModelProperty(name = "code", value = "部门(公司)编号")
    private String code;

    @ApiModelProperty(name = "parentDeptId", value = "上级部门(公司)id")
    private String parentDeptId;

    @ApiModelProperty(name = "parentDeptCode", value = "上级部门(公司)编号")
    private String parentDeptCode;

    @ApiModelProperty(name = "levels", value = "一级部门(公司)二级部门等")
    private Integer levels;

    @ApiModelProperty(name = "orgFlag", value = "是否公司")
    private Integer orgFlag;

    @ApiModelProperty(name = "creationTime", value = "部门或公司成立时间")
    private Date creationTime;

    @ApiModelProperty(name = "enableFlag", value = "是否启用")
    private Integer enableFlag;

    @ApiModelProperty(name = "type", value = "部门类型(门店，总部)")
    private Integer type;

    @ApiModelProperty(name = "delFlag", value = "是否删除")
    private Integer delFlag;

    @ApiModelProperty(name = "orderId", value = "排序")
    private Integer orderId;

    public SsoDept() {
    }

    /**
     * get 公司id
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * set 公司id
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    /**
     * get 部门(公司)名称
     */
    public String getName() {
        return name;
    }

    /**
     * set 部门(公司)名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get 部门(公司)编号
     */
    public String getCode() {
        return code;
    }

    /**
     * set 部门(公司)编号
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * get 上级部门(公司)id
     */
    public String getParentDeptId() {
        return parentDeptId;
    }

    /**
     * set 上级部门(公司)id
     */
    public void setParentDeptId(String parentDeptId) {
        this.parentDeptId = parentDeptId;
    }

    /**
     * get 上级部门(公司)编号
     */
    public String getParentDeptCode() {
        return parentDeptCode;
    }

    /**
     * set 上级部门(公司)编号
     */
    public void setParentDeptCode(String parentDeptCode) {
        this.parentDeptCode = parentDeptCode;
    }

    /**
     * get 一级部门(公司)二级部门等
     */
    public Integer getLevels() {
        return levels;
    }

    /**
     * set 一级部门(公司)二级部门等
     */
    public void setLevels(Integer levels) {
        this.levels = levels;
    }

    /**
     * get 是否公司
     */
    public Integer getOrgFlag() {
        return orgFlag;
    }

    /**
     * set 是否公司
     */
    public void setOrgFlag(Integer orgFlag) {
        this.orgFlag = orgFlag;
    }

    /**
     * get 部门或公司成立时间
     */
    public Date getCreationTime() {
        return creationTime;
    }

    /**
     * set 部门或公司成立时间
     */
    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    /**
     * get 是否启用
     */
    public Integer getEnableFlag() {
        return enableFlag;
    }

    /**
     * set 是否启用
     */
    public void setEnableFlag(Integer enableFlag) {
        this.enableFlag = enableFlag;
    }

    /**
     * get 部门类型(门店，总部)
     */
    public Integer getType() {
        return type;
    }

    /**
     * set 部门类型(门店，总部)
     */
    public void setType(Integer type) {
        this.type = type;
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
}
