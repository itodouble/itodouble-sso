package top.itodouble.sso.entity.sso.add;

import top.itodouble.sso.entity.sso.SsoMenu;

import java.util.List;

/**
 * 菜单扩展 树形结构
 */
public class SsoMenuAdd extends SsoMenu {
    /**
     * 子菜单
     */
    private List<SsoMenuAdd> children;
    /**
     * 单个角色id 角色是否拥有改菜单 用作 checked 判断
     */
    private String roleId;
    /**
     * 选中
     */
    private Boolean checked = false;

    public SsoMenuAdd() {
    }

    public List<SsoMenuAdd> getChildren() {
        return children;
    }

    public void setChildren(List<SsoMenuAdd> children) {
        this.children = children;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
}
