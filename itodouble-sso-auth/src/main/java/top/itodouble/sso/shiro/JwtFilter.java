package top.itodouble.sso.shiro;

import top.itodouble.common.pojo.CustomException;
import top.itodouble.common.pojo.RestResult;
import top.itodouble.common.utils.JsonUtils;
import top.itodouble.common.utils.StringUtils;
import top.itodouble.sso.constant.SysConstant;
import top.itodouble.sso.enums.SsoExceptionEnum;
import top.itodouble.sso.pojo.TokenBean;
import top.itodouble.sso.utils.TokenUtils;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

public class JwtFilter extends BasicHttpAuthenticationFilter {
	private static Logger logger = LoggerFactory.getLogger(JwtFilter.class);

	/**
	 * 判断用户是否想要登入。
	 * 检测header里面是否包含token字段即可
	 */
	@Override
	protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
		logger.debug("isLoginAttempt() =============================================================================");
		logger.debug("request path: =============================================================================");

		HttpServletRequest req = (HttpServletRequest) request;
		String path = req.getServletPath();
		logger.debug(path);
		if (path.matches(SysConstant.NO_INTERCEPTOR_PATH)) {
			// 不在拦截目录内
			logger.debug("不在拦截目录。。。。。。。。。。。");
			return false;
		}

		String authorization = TokenUtils.getToken(req);
		Boolean flag = StringUtils.isNotNull(authorization);
		if (!flag) {
			Enumeration<String> headerNames = req.getHeaderNames();
			while (headerNames.hasMoreElements()) {
				String name = headerNames.nextElement();
				//根据名称获取请求头的值
				String value = req.getHeader(name);
				logger.error("header name: {} value: {}", name, value);
			}
			throw new CustomException(SsoExceptionEnum.UserTokenError);
		}
		logger.debug("isLoginAttempt: " + (authorization != null));
		return authorization != null;
	}

	/**
	 * 处理用户的登录
	 */
	@Override
	protected boolean executeLogin(ServletRequest request, ServletResponse response) {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;

		/**
		 * 获取请求中的token
		 */
		String authorization = TokenUtils.getToken(httpServletRequest);
		/*if (null == authorization) {
			logger.debug("用户不存在 =============================================================================");
			throw new CustomException(SsoExceptionEnum.USER_NAME_NOTEXIST);
		}*/

		OnlyToken token = new OnlyToken(authorization);

		// 提交给realm进行登入，如果错误他会抛出异常并被捕获
		Subject subject = getSubject(request, response);
		subject.login(token);
		// 如果没有抛出异常则代表登入成功，返回true
		if (subject.isAuthenticated()) {
			TokenBean tokenBean = TokenUtils.parseJWT(authorization);
			request.setAttribute("userId", tokenBean.getUserId());
			request.setAttribute("mobile", tokenBean.getMobile());
			request.setAttribute("username", tokenBean.getUsername());
			request.setAttribute("clientIp", tokenBean.getClientIp());
			request.setAttribute("clientVersion", tokenBean.getClientVersion());
			request.setAttribute("roleIdList", tokenBean.getRoleIdList());
		}
		return true;
	}


	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		try {
			if (isLoginAttempt(request, response)) {
				return executeLogin(request, response);
			} else {
				HttpServletRequest req = (HttpServletRequest) request;
				String path = req.getServletPath();
				if (path.matches(SysConstant.NO_INTERCEPTOR_PATH)) {
					return true;
				}
			}
		} catch (ExpiredJwtException e) { // token过期
			logger.error(e.getMessage(), e);
			redirect(response, SsoExceptionEnum.UserTokenExpire);
		} catch (CustomException e) {
			logger.error(e.getExMsg(), e);
			redirect(response, new RestResult(StringUtils.toInteger(e.getCode()), e.getExMsg()));
		} catch (SignatureException e) { // 用户不存在
			logger.error(e.getMessage(), e);
			redirect(response, SsoExceptionEnum.UserNameNotExist);
		} catch (IncorrectCredentialsException e) { // 密码认证错误
			logger.error(e.getMessage(), e);
			redirect(response, SsoExceptionEnum.UserOrPasswordError);
		} catch (AuthenticationException e) { // 验证token失败
			logger.error(e.getMessage(), e);
			redirect(response, SsoExceptionEnum.UserTokenError);
		} catch (ShiroException e) {
			logger.error(e.getMessage(), e);
			redirect(response, SsoExceptionEnum.ShiroException);
		} catch (Exception e) { // token无效
			logger.error(e.getMessage(), e);
			redirect(response, RestResult.error().message(e.getMessage()));
		}
		return false;
	}

	public void redirect(ServletResponse response) {
		try {
			response.getWriter().println(JsonUtils.beanToString(RestResult.error()));
			response.flushBuffer();
			return;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void redirect(ServletResponse response, SsoExceptionEnum exceptionEnum) {
		this.redirect(response, new RestResult(exceptionEnum.getSnData(), exceptionEnum.getSnDesc()));
	}

	public void redirect(ServletResponse response, RestResult restResult) {
		try {
			/*logger.error(JsonUtils.beanToString(restResult));
			response.getWriter().println(JsonUtils.beanToString(restResult));
			response.flushBuffer();*/
			ServletOutputStream output = response.getOutputStream();
			output.write(JsonUtils.beanToString(restResult).getBytes("UTF-8"));
			output.flush();
			output.close();
			return;
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}
}
