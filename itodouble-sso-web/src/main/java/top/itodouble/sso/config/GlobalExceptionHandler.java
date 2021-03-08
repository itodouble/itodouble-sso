package top.itodouble.sso.config;

import top.itodouble.common.pojo.CustomException;
import top.itodouble.common.pojo.RestResult;
import io.jsonwebtoken.MalformedJwtException;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理
 */
@RestControllerAdvice
@Order(88)
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	public final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public RestResult exceptionHandler(Exception e) {
		logger.error("exceptionHandler..........................");
		logger.error(e.getMessage(), e);
		return RestResult.error().message("系统异常");
	}

	@ExceptionHandler(CustomException.class)
	public RestResult customExceptionHandler(CustomException e) {
		logger.error("customExceptionHandler..........................");
		logger.error(e.getExMsg(), e);
		return RestResult.error().message(e.getExMsg());
	}

	@ExceptionHandler(UnauthorizedException.class)
	public RestResult unauthorizedExceptionHandler(UnauthorizedException e){
		logger.error("unauthorizedExceptionHandler..........................");
		logger.info(e.getMessage(), e);
		return RestResult.error().message("无权限");
	}

	@ExceptionHandler({SQLIntegrityConstraintViolationException.class, DuplicateKeyException.class})
	public RestResult sQLIntegrityConstraintViolationExceptionHandler(SQLIntegrityConstraintViolationException e) {
		logger.error("sQLIntegrityConstraintViolationExceptionHandler..........................");
		logger.info(e.getMessage(), e);
		return RestResult.error().message("数据重复");
	}

	@ExceptionHandler(MalformedJwtException.class)
	public RestResult malformedJwtExceptionHandler(MalformedJwtException e){
		logger.error("malformedJwtExceptionHandler..........................");
		logger.error(e.getMessage(), e);
		return RestResult.error().message("token格式异常");
	}

	@ExceptionHandler(AuthenticationException.class)
	public RestResult authenticationExceptionHandler(AuthenticationException e) {
		logger.error("authenticationExceptionHandler..........................");
		logger.error(e.getMessage(), e);
		return RestResult.error().message("登录异常");
	}

	@ExceptionHandler(IncorrectCredentialsException.class) 
	public RestResult incorrectCredentialsExceptionHandler(IncorrectCredentialsException e){
		logger.error("incorrectCredentialsExceptionHandler..........................");
		logger.error(e.getMessage(), e);
		return RestResult.error().message("登录异常");

	}

	@ExceptionHandler(ShiroException.class)
	public RestResult shiroExceptionHandler(ShiroException e){
		logger.error("shiroExceptionHandler..........................");
		if(e instanceof IncorrectCredentialsException)
			return RestResult.error().message("密码不正确");
		else if(e instanceof UnknownAccountException)
			return RestResult.error().message("此账户不存在");
		else if(e instanceof LockedAccountException)
			return RestResult.error().message("账户已被禁用");
		return RestResult.error().message("shiro异常");
	}
}
