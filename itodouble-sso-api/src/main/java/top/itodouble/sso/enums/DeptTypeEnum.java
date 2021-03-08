package top.itodouble.sso.enums;

import top.itodouble.common.Base.BaseEnum;

/**
 * 部门类型
 * sso_dept.type
 */
public enum DeptTypeEnum implements BaseEnum {
    HeadOffice("HeadOffice", 1, "总部"),
    StoreOffice("StoreOffice", 2, "门店");
    private String sn;
    private Integer snData;
    private String snDesc;

    DeptTypeEnum(String sn, Integer snData, String snDesc) {
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
