package top.itodouble.sso.config;


import top.itodouble.common.utils.ClassUtils;
import top.itodouble.common.utils.StringUtils;
import top.itodouble.common.utils.UuidUtils;
import top.itodouble.sso.pojo.TokenBean;
import top.itodouble.sso.utils.TokenUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * uuid 拦截器
 * 为id生成uuid
 * 只拦截top.itodouble.sso.mapper.sso包中的类中insert开头的方法
 */
@Component
@Aspect
public class MyBatisInsertInterceptor {
	private static Logger logger = LoggerFactory.getLogger(MyBatisInsertInterceptor.class);

	@Before("execution(* top.itodouble.sso.mapper.sso..*.insert*(..))")
	public void pointCut(JoinPoint point) throws ClassNotFoundException, IntrospectionException, InvocationTargetException, IllegalAccessException {
		Object[] args = point.getArgs();
		String targetName = point.getTarget().getClass().getName();
		String methodName = point.getSignature().getName();
		Class targetClass = Class.forName(targetName);
		Method[] methods = targetClass.getMethods();

		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				Object obj = args[0];

				Method setIdMethod = ClassUtils.getSetMethod(args[0].getClass(), "id");
				Method getIdMethod = ClassUtils.getGetMethod(args[0].getClass(), "id");

				String id = (String) getIdMethod.invoke(obj, null);
				if (!StringUtils.isNotNull(id)) {
					setIdMethod.invoke(obj, UuidUtils.gen());
				}
				String token = null;
				try {
					HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
					token = request.getHeader("token");
				} catch (Exception e) {
					logger.warn("没有request");
				}
				if (StringUtils.isNotNull(token)) {
					try {
						TokenBean tokenBean = TokenUtils.parseJWT(token);
						if (null != tokenBean) {
							try {
								Method getCreateUserId = ClassUtils.getGetMethod(args[0].getClass(), "createUserId");
								String createUserId = (String) getCreateUserId.invoke(obj, null);
								if (!StringUtils.isNotNull(createUserId)) {
									Method setCreateUserId = ClassUtils.getSetMethod(args[0].getClass(), "createUserId");
									setCreateUserId.invoke(obj, tokenBean.getUserId());
								}
							} catch (Exception e) {
								logger.info("该类没有set createUserId" + args[0].getClass());
							}
							try {
								Method getUpdateUserId = ClassUtils.getGetMethod(args[0].getClass(), "updateUserId");
								String updateUserId = (String) getUpdateUserId.invoke(obj, null);
								if (!StringUtils.isNotNull(updateUserId)) {
									Method setUpdateUserId = ClassUtils.getSetMethod(args[0].getClass(), "updateUserId");
									setUpdateUserId.invoke(obj, tokenBean.getUserId());
								}
							} catch (Exception e) {
								logger.info("该类没有set updateUserId" + args[0].getClass());
							}
						}
					} catch (Exception e) {
						logger.warn(e.getMessage(), e);
					}
				}
				try {
					Method setCreateTime = ClassUtils.getSetMethod(args[0].getClass(), "createTime");
					setCreateTime.invoke(obj, new Date());
				} catch (Exception e) {
					logger.info("该类没有set createTime" + args[0].getClass());
				}
				try {
					Method setUpdateTime = ClassUtils.getSetMethod(args[0].getClass(), "updateTime");
					setUpdateTime.invoke(obj, new Date());
				} catch (Exception e) {
					logger.info("该类没有set updateTime" + args[0].getClass());
				}
			}
		}


	}

}
