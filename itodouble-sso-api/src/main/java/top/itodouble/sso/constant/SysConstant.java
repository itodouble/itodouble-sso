package top.itodouble.sso.constant;

public class SysConstant {
    // 不需要拦截的目录
    public static final String NO_INTERCEPTOR_PATH = ".*/((static)|(login)|(notLogin)|(logout)|(error)|(front)|(callback)|(task)).*";
    // 请求时token存放的位置
    public static final String TOKEN_NAME = "token";
}
