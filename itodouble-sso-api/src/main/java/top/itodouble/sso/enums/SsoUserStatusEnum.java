package top.itodouble.sso.enums;

import top.itodouble.common.Base.BaseEnum;

/**
 * 用户账号状态
 */
public enum SsoUserStatusEnum implements BaseEnum {
    Enable("enable", 1, "正常"),
    Disable("disable", 2, "禁用"),
    Frozen("frozen", 3, "冻结");

    /**
     * 是否可用
     *
     * @param status
     * @return
     */
    public static Boolean enable(Integer status) {
        if (status == Enable.snData) {
            return true;
        }
        return false;
    }

    private String sn;
    private Integer snData;
    private String snDesc;

    SsoUserStatusEnum() {
    }

    SsoUserStatusEnum(String sn, Integer snData, String snDesc) {
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
