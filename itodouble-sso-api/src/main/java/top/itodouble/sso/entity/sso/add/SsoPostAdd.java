package top.itodouble.sso.entity.sso.add;

import top.itodouble.sso.entity.sso.SsoPost;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "岗位 扩展")
public class SsoPostAdd extends SsoPost implements Serializable {
    @ApiModelProperty(value = "部门名称")
    private String deptName;
    @ApiModelProperty(value = "岗位名称")
    private String orgName;

    @ApiModelProperty(value = "是否是岗位")
    private Integer isPost;

    private List<SsoDeptAdd> children;
    private Boolean hasChildren;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
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

    public Integer getIsPost() {
        return isPost;
    }

    public void setIsPost(Integer isPost) {
        this.isPost = isPost;
    }
}
