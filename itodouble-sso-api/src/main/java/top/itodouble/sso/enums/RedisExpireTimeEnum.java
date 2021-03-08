package top.itodouble.sso.enums;

import top.itodouble.common.Base.BaseEnum;

public enum RedisExpireTimeEnum implements BaseEnum {
    SsoUser("sso_user", 2000l, "登录用户");

    private String sn;
    private Long snData;
    private String snDesc;

    RedisExpireTimeEnum(String sn, Long snData, String snDesc) {
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
    public Long getSnData() {
        return snData;
    }

    public void setSnData(Long snData) {
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
