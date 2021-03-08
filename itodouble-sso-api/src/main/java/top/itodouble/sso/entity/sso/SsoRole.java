package top.itodouble.sso.entity.sso;

import top.itodouble.common.Base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>说明： 实体类</P>
 */
@ApiModel("")
public class SsoRole extends BaseEntity implements Serializable {

    @ApiModelProperty(name = "systemCode", value = "所属系统")
    private String systemCode;

    @ApiModelProperty(name = "name", value = "角色名称")
    private String name;

    @ApiModelProperty(name = "code", value = "角色code")
    private String code;

    @ApiModelProperty(name = "enableFlag", value = "是否启用")
    private Integer enableFlag;

    @ApiModelProperty(name = "delFlag", value = "删除")
    private Integer delFlag;

    public SsoRole() {
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
     * get 角色名称
     */
    public String getName() {
        return name;
    }

    /**
     * set 角色名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get 角色code
     */
    public String getCode() {
        return code;
    }

    /**
     * set 角色code
     */
    public void setCode(String code) {
        this.code = code;
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
     * get 删除
     */
    public Integer getDelFlag() {
        return delFlag;
    }

    /**
     * set 删除
     */
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
}
