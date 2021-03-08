package top.itodouble.sso.entity.sso;

import top.itodouble.common.Base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>说明： 实体类</P>
 */
@ApiModel("")
public class SsoPermission extends BaseEntity implements Serializable {

    @ApiModelProperty(name = "userId", value = "单独赋予权限")
    private String userId;

    @ApiModelProperty(name = "roleId", value = "")
    private String roleId;

    @ApiModelProperty(name = "menuId", value = "")
    private String menuId;

    @ApiModelProperty(name = "enableFlag", value = "")
    private Integer enableFlag;

    @ApiModelProperty(name = "delFlag", value = "")
    private Integer delFlag;

    public SsoPermission() {
    }

    /**
     * get 单独赋予权限
     */
    public String getUserId() {
        return userId;
    }

    /**
     * set 单独赋予权限
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public Integer getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(Integer enableFlag) {
        this.enableFlag = enableFlag;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
}
