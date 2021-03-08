package top.itodouble.sso.entity.sso;

import top.itodouble.common.Base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>说明： 关联系统实体类</P>
 */
@ApiModel("关联系统")
public class SsoSystem extends BaseEntity implements Serializable {

    @ApiModelProperty(name = "systemCode", value = "系统code")
    private String systemCode;

    @ApiModelProperty(name = "systemDesc", value = "系统说明")
    private String systemDesc;

    @ApiModelProperty(name = "systemModelCode", value = "(模块code)")
    private String systemModelCode;

    public SsoSystem() {
    }

    /**
     * get 系统code
     */
    public String getSystemCode() {
        return systemCode;
    }

    /**
     * set 系统code
     */
    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    /**
     * get 系统说明
     */
    public String getSystemDesc() {
        return systemDesc;
    }

    /**
     * set 系统说明
     */
    public void setSystemDesc(String systemDesc) {
        this.systemDesc = systemDesc;
    }

    /**
     * get (模块code)
     */
    public String getSystemModelCode() {
        return systemModelCode;
    }

    /**
     * set (模块code)
     */
    public void setSystemModelCode(String systemModelCode) {
        this.systemModelCode = systemModelCode;
    }
}
