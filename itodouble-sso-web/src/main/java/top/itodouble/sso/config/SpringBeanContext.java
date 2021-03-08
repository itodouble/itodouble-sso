package top.itodouble.sso.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanContext implements ApplicationContextAware {
	private static ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringBeanContext.applicationContext = applicationContext;
	}

	public static ApplicationContext getApplicationContext(){
		return applicationContext;
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) throws BeansException {
		return (T)applicationContext.getBean(name);
	}

	public static <T> T getBean(Class<T> clz) throws BeansException {
		return (T)applicationContext.getBean(clz);
	}
}
