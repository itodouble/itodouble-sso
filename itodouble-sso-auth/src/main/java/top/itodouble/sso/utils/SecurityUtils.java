package top.itodouble.sso.utils;

import top.itodouble.sso.pojo.TokenBean;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class SecurityUtils {
    public static TokenBean getTokenBean() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = TokenUtils.getToken(request);
        return TokenUtils.parseJWT(token);
    }
}
