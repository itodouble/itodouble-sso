package top.itodouble.sso.entity.sso;

import top.itodouble.common.Base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>说明： 数据字典表实体类</P>
 */
@ApiModel("数据字典表")
public class SsoDict extends BaseEntity implements Serializable {

    @ApiModelProperty(name = "dictPrefix", value = "数据字典分组")
    private String dictPrefix;

    @ApiModelProperty(name = "dictSn", value = "数据字典sn")
    private String dictSn;

    @ApiModelProperty(name = "dictData", value = "数据字典数据")
    private Integer dictData;

    @ApiModelProperty(name = "dictDesc", value = "解释说明(显示内容)")
    private String dictDesc;

    @ApiModelProperty(name = "systemCode", value = "所属系统")
    private String systemCode;

    @ApiModelProperty(name = "enableFlag", value = "是否启用")
    private Integer enableFlag;

    @ApiModelProperty(name = "delFlag", value = "是否删除")
    private Integer delFlag;

    @ApiModelProperty(name = "orderId", value = "排序")
    private Integer orderId;

    public SsoDict() {
    }

    /**
     * get 数据字典分组
     */
    public String getDictPrefix() {
        return dictPrefix;
    }

    /**
     * set 数据字典分组
     */
    public void setDictPrefix(String dictPrefix) {
        this.dictPrefix = dictPrefix;
    }

    /**
     * get 数据字典sn
     */
    public String getDictSn() {
        return dictSn;
    }

    /**
     * set 数据字典sn
     */
    public void setDictSn(String dictSn) {
        this.dictSn = dictSn;
    }

    /**
     * get 数据字典数据
     */
    public Integer getDictData() {
        return dictData;
    }

    /**
     * set 数据字典数据
     */
    public void setDictData(Integer dictData) {
        this.dictData = dictData;
    }

    /**
     * get 解释说明(显示内容)
     */
    public String getDictDesc() {
        return dictDesc;
    }

    /**
     * set 解释说明(显示内容)
     */
    public void setDictDesc(String dictDesc) {
        this.dictDesc = dictDesc;
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
