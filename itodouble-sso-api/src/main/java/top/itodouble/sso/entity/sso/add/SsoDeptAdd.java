package top.itodouble.sso.entity.sso.add;

import top.itodouble.sso.entity.sso.SsoDept;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel("SsoDept 部门 扩展字段")
public class SsoDeptAdd extends SsoDept implements Serializable {
    @ApiModelProperty(value = "公司名称")
    private String orgName;
    @ApiModelProperty(value = "公司code")
    private String orgCode;
    @ApiModelProperty(value = "上级部门名称")
    private String parentDeptName;

    private List<SsoDeptAdd> children;
    private Boolean hasChildren;
    private SsoDeptAdd parent;

    public SsoDeptAdd() {
    }

    public SsoDeptAdd(SsoDept ssoDept) {
        if (null != ssoDept) {
            this.setId(ssoDept.getId());
            this.setOrgId(ssoDept.getOrgId());
            this.setName(ssoDept.getName());
            this.setCode(ssoDept.getCode());
            this.setParentDeptId(ssoDept.getParentDeptId());
            this.setParentDeptCode(ssoDept.getParentDeptCode());
            this.setLevels(ssoDept.getLevels());
            this.setOrgFlag(ssoDept.getOrgFlag());
            this.setCreationTime(ssoDept.getCreationTime());
            this.setEnableFlag(ssoDept.getEnableFlag());
            this.setType(ssoDept.getType());
            this.setDelFlag(ssoDept.getDelFlag());
            this.setOrderId(ssoDept.getOrderId());
        }
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getParentDeptName() {
        return parentDeptName;
    }

    public void setParentDeptName(String parentDeptName) {
        this.parentDeptName = parentDeptName;
    }

    public List<SsoDeptAdd> getChildren() {
        return children;
    }

    public void setChildren(List<SsoDeptAdd> children) {
        this.children = children;
    }

    public Boolean getHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(Boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public SsoDeptAdd getParent() {
        return parent;
    }

    public void setParent(SsoDeptAdd parent) {
        this.parent = parent;
    }
}
