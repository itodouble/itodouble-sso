package top.itodouble.sso.entity.sso;

import top.itodouble.common.Base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import java.util.Date;

/**
 * <p>说明： 岗位实体类</P>
 */
@ApiModel("岗位")
public class SsoPost extends BaseEntity implements Serializable {

    @ApiModelProperty(name = "name", value = "岗位名称")
    private String name;

    @ApiModelProperty(name = "code", value = "")
    private String code;

    @ApiModelProperty(name = "creationTime", value = "岗位成立时间")
    private Date creationTime;

    @ApiModelProperty(name = "enableFlag", value = "是否启用")
    private Integer enableFlag;

    @ApiModelProperty(name = "orgId", value = "公司")
    private String orgId;

    @ApiModelProperty(name = "deptId", value = "岗位所在部门")
    private String deptId;

    @ApiModelProperty(name = "delFlag", value = "是否删除")
    private Integer delFlag;

    @ApiModelProperty(name = "orderId", value = "排序")
    private Integer orderId;

    public SsoPost() {
    }

    /**
     * get 岗位名称
     */
    public String getName() {
        return name;
    }

    /**
     * set 岗位名称
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * get 岗位成立时间
     */
    public Date getCreationTime() {
        return creationTime;
    }

    /**
     * set 岗位成立时间
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
     * get 公司
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * set 公司
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    /**
     * get 岗位所在部门
     */
    public String getDeptId() {
        return deptId;
    }

    /**
     * set 岗位所在部门
     */
    public void setDeptId(String deptId) {
        this.deptId = deptId;
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
