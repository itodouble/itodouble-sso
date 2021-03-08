package top.itodouble.sso.shiro;


import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
	@Value("${shiro.hashalgorithmname:MD5}")
	private String HashAlgorithmName;

	@Value("${shiro.hashinterations:1}")
	private Integer HASH_INTERATIONS;

	@Bean
	public ShiroFilterFactoryBean shirFilter(
			@Qualifier(value = "securityManager") SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		// 必须设置 SecurityManager
		shiroFilterFactoryBean.setSecurityManager(securityManager);

		// 添加自己的过滤器
		Map<String, Filter> filterMap = new LinkedHashMap<>();
		filterMap.put("jwtFilter", new JwtFilter());

		shiroFilterFactoryBean.setFilters(filterMap);

		//setLoginUrl 如果不设置值，默认会自动寻找Web工程根目录下的"/login.jsp"页面 或 "/login" 映射
		//shiroFilterFactoryBean.setLoginUrl("/user/login");

		// 设置拦截器
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();

		filterChainDefinitionMap.put("/auth/login","anon"); // 系统用户登录
		filterChainDefinitionMap.put("/auth/logout","anon"); // 系统用户登出
		filterChainDefinitionMap.put("/error/*","anon"); // 异常
		filterChainDefinitionMap.put("/front/**", "anon"); // 开放

		filterChainDefinitionMap.put("/swagger-ui.html", "anon");
		filterChainDefinitionMap.put("/swagger-resources/**","anon");
		filterChainDefinitionMap.put("/webjars/**", "anon");
		filterChainDefinitionMap.put("/webjars/springfox-swagger-ui/**", "anon");
		filterChainDefinitionMap.put("/v2/api-docs", "anon");

		//所有的请求都经过 自定义的过滤器
		filterChainDefinitionMap.put("/**","jwtFilter");

		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}


	@Bean(value = "jwtRealm")
	public JwtRealm jwtRealm(@Qualifier("hashedCredentialsMatcher") HashedCredentialsMatcher hashedCredentialsMatcher) {
		JwtRealm jwtRealm = new JwtRealm();
		jwtRealm.setCredentialsMatcher(hashedCredentialsMatcher);
		return jwtRealm;
	}

	/**
	 * 配置SecurityManager
	 * @param modularRealmAuthenticator 多realm 认证
	 * @param modularRealmAuthorizer 多 realm 授权
	 * @return
	 */

	@Bean(value = "securityManager")
	public DefaultWebSecurityManager securityManager(
			@Qualifier(value = "modularRealmAuthenticator") ModularRealmAuthenticator modularRealmAuthenticator,
			@Qualifier(value = "modularRealmAuthorizer") ModularRealmAuthorizer modularRealmAuthorizer
	) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setAuthenticator(modularRealmAuthenticator);
		securityManager.setAuthorizer(modularRealmAuthorizer);
		return securityManager;
	}


	/**
	 * 自带的Realm管理 多realm认证
	 * @param jwtRealm
	 * @return
	 */
	@Bean(value = "modularRealmAuthenticator")
	public ModularRealmAuthenticator modularRealmAuthenticator(

			@Qualifier(value = "jwtRealm") JwtRealm jwtRealm
	){
		ModularRealmAuthenticator  modularRealmAuthenticator = new ModularRealmAuthenticator ();
		modularRealmAuthenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
		Collection<Realm> crealms = new ArrayList<>();

		crealms.add(jwtRealm);
		modularRealmAuthenticator.setRealms(crealms);
		return modularRealmAuthenticator;
	}

	/**
	 * 自带的Realm管理 多realm 授权
	 * @param jwtRealm
	 * @return
	 */

	@Bean(value = "modularRealmAuthorizer")
	public ModularRealmAuthorizer modularRealmAuthorizer(@Qualifier(value = "jwtRealm") JwtRealm jwtRealm){
		ModularRealmAuthorizer modularRealmAuthorizer = new ModularRealmAuthorizer ();
		Collection<Realm> crealms = new ArrayList<>();
		crealms.add(jwtRealm);
		modularRealmAuthorizer.setRealms(crealms);
		return modularRealmAuthorizer;
	}

	/**
	 * 配置加密方式和散列次数
	 * @return
	 */
	@Bean(value = "hashedCredentialsMatcher")
	public HashedCredentialsMatcher getHashedCredentialsMatcher() {
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		hashedCredentialsMatcher.setHashAlgorithmName(HashAlgorithmName); // 设置加密方式
		hashedCredentialsMatcher.setHashIterations(HASH_INTERATIONS); // 设置散列次数
		return hashedCredentialsMatcher;
	}

	/**
	 * 启动shiro 注解拦截
	 * @param defaultWebSecurityManager
	 * @return
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier(value = "securityManager")DefaultWebSecurityManager defaultWebSecurityManager) {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(defaultWebSecurityManager);
		return authorizationAttributeSourceAdvisor;
	}

	/**
	 * aop开启
	 * @return
	 */
	@Bean
	public static DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator(){
		DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
		defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
		return defaultAdvisorAutoProxyCreator;
	}


}
