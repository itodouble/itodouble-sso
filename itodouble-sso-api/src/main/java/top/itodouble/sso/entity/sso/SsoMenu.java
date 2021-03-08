package top.itodouble.sso.entity.sso;

import top.itodouble.common.Base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>说明： 菜单按钮实体类</P>
 */
@ApiModel("菜单按钮")
public class SsoMenu extends BaseEntity implements Serializable {

    @ApiModelProperty(name = "systemCode", value = "所属系统")
    private String systemCode;

    @ApiModelProperty(name = "name", value = "菜单按钮名称")
    private String name;

    @ApiModelProperty(name = "parentId", value = "父级id")
    private String parentId;

    @ApiModelProperty(name = "urlPath", value = "请求路径")
    private String urlPath;

    @ApiModelProperty(name = "urlType", value = "前端地址 后端地址 按钮")
    private Integer urlType;

    @ApiModelProperty(name = "permissionCode", value = "接口权限code")
    private String permissionCode;

    @ApiModelProperty(name = "component", value = "页面文件路径 @/views/components-demo/markdown")
    private String component;

    @ApiModelProperty(name = "hideFlag", value = "隐藏")
    private Integer hideFlag;

    @ApiModelProperty(name = "sort", value = "排序")
    private Integer sort;

    @ApiModelProperty(name = "delFlag", value = "是否删除")
    private Integer delFlag;

    @ApiModelProperty(name = "enableFlag", value = "是否启用")
    private Integer enableFlag;

    @ApiModelProperty(name = "urlMeta", value = "样式等信息json")
    private String urlMeta;

    public SsoMenu() {
    }

    /**
     * get 所属系统
     */
    public String getSystemCode() {
        return systemCode;
    }

    /**
     * set 所属系统
     */
    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    /**
     * get 菜单按钮名称
     */
    public String getName() {
        return name;
    }

    /**
     * set 菜单按钮名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get 父级id
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * set 父级id
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * get 请求路径
     */
    public String getUrlPath() {
        return urlPath;
    }

    /**
     * set 请求路径
     */
    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    /**
     * get 前端地址 后端地址 按钮
     */
    public Integer getUrlType() {
        return urlType;
    }

    /**
     * set 前端地址 后端地址 按钮
     */
    public void setUrlType(Integer urlType) {
        this.urlType = urlType;
    }

    /**
     * get 接口权限code
     */
    public String getPermissionCode() {
        return permissionCode;
    }

    /**
     * set 接口权限code
     */
    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    /**
     * get 页面文件路径 @/views/components-demo/markdown
     */
    public String getComponent() {
        return component;
    }

    /**
     * set 页面文件路径 @/views/components-demo/markdown
     */
    public void setComponent(String component) {
        this.component = component;
    }

    /**
     * get 隐藏
     */
    public Integer getHideFlag() {
        return hideFlag;
    }

    /**
     * set 隐藏
     */
    public void setHideFlag(Integer hideFlag) {
        this.hideFlag = hideFlag;
    }

    /**
     * get 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * set 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
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
     * get 样式等信息json
     */
    public String getUrlMeta() {
        return urlMeta;
    }

    /**
     * set 样式等信息json
     */
    public void setUrlMeta(String urlMeta) {
        this.urlMeta = urlMeta;
    }
}
