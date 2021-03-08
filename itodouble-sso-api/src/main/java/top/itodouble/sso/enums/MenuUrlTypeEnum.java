package top.itodouble.sso.enums;

import top.itodouble.common.Base.BaseEnum;

public enum MenuUrlTypeEnum implements BaseEnum {
    Menu("menu", 1, "菜单"),
    Controller("controller", 2, "后台请求路径"),
    Button("button", 3, "按钮");

    private String sn;
    private Integer snData;
    private String snDesc;

    MenuUrlTypeEnum() {
    }

    MenuUrlTypeEnum(String sn, Integer snData, String snDesc) {
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
