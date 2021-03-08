package top.itodouble.sso.entity.sso;

import top.itodouble.common.Base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>说明： 省市区 地址信息实体类</P>
 */
@ApiModel("省市区 地址信息")
public class SsoArea extends BaseEntity implements Serializable {

    @ApiModelProperty(name = "delFlag", value = "是否删除")
    private Integer delFlag;

    @ApiModelProperty(name = "code", value = "code")
    private String code;

    @ApiModelProperty(name = "name", value = "name")
    private String name;

    @ApiModelProperty(name = "parentId", value = "")
    private String parentId;

    @ApiModelProperty(name = "parentCode", value = "")
    private String parentCode;

    public SsoArea() {
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
     * get code
     */
    public String getCode() {
        return code;
    }

    /**
     * set code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * get name
     */
    public String getName() {
        return name;
    }

    /**
     * set name
     */
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
}
