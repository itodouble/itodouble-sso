package top.itodouble.sso.enums;

import top.itodouble.common.Base.BaseEnum;

/**
 * 用户账号类型
 */
public enum SsoUserTypeEnum implements BaseEnum {
    Inside("inside",1,"内部用户"),
    Outside("outside",2,"外部用户");
    
    private String sn;
    private Integer snData;
    private String snDesc;

    SsoUserTypeEnum(String sn, Integer snData, String snDesc) {
        this.sn = sn;
        this.snData = snData;
        this.snDesc = snDesc;
    }

    @Override
    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    @Override
    public Integer getSnData() {
        return snData;
    }

    public void setSnData(Integer snData) {
        this.snData = snData;
    }

    @Override
    public String getSnDesc() {
        return snDesc;
    }

    public void setSnDesc(String snDesc) {
        this.snDesc = snDesc;
    }
}
