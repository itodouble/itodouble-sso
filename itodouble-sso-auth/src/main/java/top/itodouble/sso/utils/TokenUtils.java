package top.itodouble.sso.utils;

import top.itodouble.common.utils.StringUtils;
import top.itodouble.sso.constant.SysConstant;
import top.itodouble.sso.pojo.TokenBean;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;


@Component
public class TokenUtils {

    private static String secret;
    private static String issuer;
    private static Boolean accessTokenExpireFlag;
    private static Long accessTokenExpireTime;

    /**
     * 获取request中的token
     * @param request
     * @return
     */
    public static String getToken(HttpServletRequest request) {
        String authorization = null;
        if (StringUtils.isNotNull(request.getHeader(SysConstant.TOKEN_NAME))) {
            authorization = request.getHeader(SysConstant.TOKEN_NAME);
        } else if (StringUtils.isNotNull(request.getParameter(SysConstant.TOKEN_NAME))) {
            authorization = request.getParameter(SysConstant.TOKEN_NAME);
        } else if (StringUtils.isNotNull(request.getHeader("Sec-WebSocket-Protocol"))) {
            authorization = request.getHeader("Sec-WebSocket-Protocol");
        } else {
            Cookie[] cookieArr = request.getCookies();
            if(cookieArr != null && cookieArr.length>0 ) {
                for(Cookie cookie : cookieArr) {
                    if(SysConstant.TOKEN_NAME.equals(cookie.getName())) {
                        authorization = cookie.getValue();
                        break;
                    }
                }
            }
        }
        return authorization;
    }

    /**
     * 生成token
     *
     * @param tokenBean userId和userType必填
     * @return
     */
    public static String createJwtToken(TokenBean tokenBean) {
        // 签名算法 ，将对token进行签名
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        String jcaName = signatureAlgorithm.getJcaName();

        // 生成签发时间
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        // 通过秘钥签名JWT
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secret);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, jcaName);

        // JWT参数
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
                .claim("userId", tokenBean.getUserId())
                .claim("mobile", tokenBean.getMobile())
                .claim("username", tokenBean.getUsername())
                .claim("clientIp", tokenBean.getClientIp())
                .claim("clientVersion", tokenBean.getClientVersion())
                .claim("name", tokenBean.getName())
                .claim("loginName", tokenBean.getLoginName())
                .claim("loginPwd", tokenBean.getLoginPwd())
                .claim("authTime", now)
                .setIssuer(issuer)
                .signWith(signatureAlgorithm, signingKey);
        // token 过期时间
        if (accessTokenExpireFlag) {
            Date exp = new Date(nowMillis + accessTokenExpireTime);
            builder.setExpiration(exp);
        }
        return builder.compact();

    }

    /**
     * 解析jwt字符串
     *
     * @param token
     * @return
     */
    public static TokenBean parseJWT(String token) {

        TokenBean tokenBean = new TokenBean();
        Claims claims = null;
        try {
            claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(secret)).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            //throw new CustomException(SsoExceptionEnum.UserTokenError);
            return null;
        }

        tokenBean.setUserId(claims.get("userId", String.class));
        tokenBean.setMobile(claims.get("mobile", String.class));
        tokenBean.setUsername(claims.get("username", String.class));
        tokenBean.setClientIp(claims.get("clientIp", String.class));
        tokenBean.setClientVersion(claims.get("clientVersion", String.class));
        tokenBean.setName(claims.get("name", String.class));
        tokenBean.setLoginName(claims.get("loginName", String.class));
        tokenBean.setLoginPwd(claims.get("loginPwd", String.class));
        return tokenBean;

    }

    @Value("${shiro.token.secret:itodouble}")
    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Value("${shiro.token.issuer:top.itodouble}")
    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    @Value("${shiro.token.access.expire.flag:false}")
    public void setAccessTokenExpireFlag(Boolean accessTokenExpireFlag) {
        this.accessTokenExpireFlag = accessTokenExpireFlag;
    }

    @Value("${shiro.token.access.expire.time:300000}")
    public void setAccessTokenExpireTime(Long accessTokenExpireTime) {
        this.accessTokenExpireTime = accessTokenExpireTime;
    }

}
