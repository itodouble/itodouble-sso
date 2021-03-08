package top.itodouble.sso.pojo;

/**
 * 地址信息扩展
 */

import top.itodouble.sso.entity.sso.SsoArea;

import java.util.List;

public class AreaPojo {
    private String id;
    private String code;
    private String name;
    private String parentId;
    private String parentCode;
    private List<AreaPojo> children;
    private Boolean hasChildren;
    private AreaPojo parent;

    public AreaPojo() {
    }

    public AreaPojo(SsoArea ssoArea) {
        if (null != ssoArea) {
            id = ssoArea.getId();
            code = ssoArea.getCode();
            name = ssoArea.getName();
            parentId = ssoArea.getParentId();
            parentCode = ssoArea.getParentCode();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public List<AreaPojo> getChildren() {
        return children;
    }

    public void setChildren(List<AreaPojo> children) {
        this.children = children;
    }

    public Boolean getHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(Boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public AreaPojo getParent() {
        return parent;
    }

    public void setParent(AreaPojo parent) {
        this.parent = parent;
    }
}
