package top.itodouble.sso.enums;

import top.itodouble.common.Base.BaseEnum;

public enum SsoExceptionEnum implements BaseEnum {
    /**
     * 10000 ~ 10100 为登录等信息异常code
     **/
    UserNameNotExist("user_name_not_exist", 10003, "用户不存在"),
    UserNotExist("user_not_exist", 10004, "用户为空"),
    UserOrPasswordError("user_or_password_error", 10005, "用户手机号或者密码错误"),
    UserIllegalArgs("user_illegal_args", 10006, "用户参数传递不正确"),
    UserPasswordFormatError("user_password_format_error", 10007, "密码格式不正确，至少6位，但不超过16位"),
    UserForgetPasswordError("user_forget_password_error", 10009, "用户忘记密码修改失败"),
    UserSamePasswordError("user_same_password_error", 10010, "新密码不能与旧密码相同"),
    UserNamePasswordError("user_name_password_error", 10011, "用户名密码不正确"),
    UserLogbackInError("user_logback_in_error", 10012, "请重新登录"),

    /**
     * token有问题
     */
    UserTokenError("user_token_error", 10013, "登录信息异常"),
    UserTokenExpire("user_token_expire", 10014, "登录过期"),
    ShiroException("shiro_exception", 10015, "权限异常");
    private String sn;
    private Integer snData;
    private String snDesc;

    SsoExceptionEnum(String sn, Integer snData, String snDesc) {
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
