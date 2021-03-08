package top.itodouble.sso.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import top.itodouble.sso.mapper.sso.SsoMapperScanMarker;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@MapperScan(basePackageClasses = {SsoMapperScanMarker.class}, sqlSessionFactoryRef = "sso_default_sqlSessionFactory")
public class SsoDataSourceConfig {

	@Value("${spring.datasource.sso.dbname}")
	private String name;
	@Value("${spring.datasource.sso.driverClassName}")
	private String driverClassName;
	@Value("${spring.datasource.sso.type}")
	private String type;
	@Value("${spring.datasource.sso.jdbcUrl}")
	private String jdbcUrl;
	@Value("${spring.datasource.sso.username}")
	private String username;
	@Value("${spring.datasource.sso.password}")
	private String password;
	@Value("${spring.datasource.sso.initialSize}")
	private int initialSize;
	@Value("${spring.datasource.sso.maxActive}")
	private int maxActive;
	@Value("${spring.datasource.sso.minIdle}")
	private int minIdle;
	@Value("${spring.datasource.sso.testWhileIdle}")
	private Boolean testWhileIdle;


	@Bean(name = "sso_default_dataSource")
	@ConfigurationProperties(prefix = "spring.datasource.sso")
	public DataSource ssoDataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setName(name);
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(jdbcUrl);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setInitialSize(initialSize);
		dataSource.setMaxActive(maxActive);
		dataSource.setMinIdle(minIdle);
		dataSource.setTestWhileIdle(true);
		dataSource.setDbType(type);
		dataSource.setTestWhileIdle(testWhileIdle);
		return dataSource;
	}

	@Bean(name = "sso_default_transactionManager")
	public DataSourceTransactionManager ssoTransactionManager(@Qualifier("sso_default_dataSource") DataSource dataSource) {
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
		dataSourceTransactionManager.setDataSource(dataSource);
		return dataSourceTransactionManager;
	}

	@Bean(name = "sso_default_transactionTemplate")
	public TransactionTemplate transactionTemplate(@Qualifier("sso_default_transactionManager") DataSourceTransactionManager txManager) {
		TransactionTemplate tt = new TransactionTemplate();
		tt.setTransactionManager(txManager);
		return tt;
	}

	/**
	 * 用纯JDBC实现DAO的相关设置(可选)
	 *
	 * @return
	 */
	@Bean(name = "sso_default_jdbcTemplate")
	public JdbcTemplate jdbcTemplate(@Qualifier("sso_default_dataSource") DataSource dataSource) {
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(dataSource);
		return jt;
	}


	@Bean(name = "sso_default_sqlSessionFactory")
	public SqlSessionFactory ssoSqlSessionFactory(@Qualifier("sso_default_dataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);

		Interceptor interceptor = new PageInterceptor();
		Properties properties = new Properties();
		properties.setProperty("helperDialect", "mysql");
		properties.setProperty("offsetAsPageNum", "true");
		properties.setProperty("rowBoundsWithCount", "true");
		properties.setProperty("reasonable", "true");
		properties.setProperty("supportMethodsArguments", "true");
		interceptor.setProperties(properties);
		bean.setPlugins(new Interceptor[]{interceptor});

		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/sso/**/*.xml"));
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		bean.setConfigLocation(resolver.getResource("classpath:/mybatis/mybatis-config.xml"));
		return bean.getObject();
	}

}
