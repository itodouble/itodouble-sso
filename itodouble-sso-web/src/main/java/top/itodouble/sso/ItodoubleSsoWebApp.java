package top.itodouble.sso;

import top.itodouble.common.pojo.RestResult;
import top.itodouble.sso.mapper.sso.SsoMapperScanMarker;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;

@EnableAutoConfiguration
@EnableDubbo
@EnableScheduling
@ComponentScan(
		basePackages = {
				"top.itodouble.sso",
				"top.itodouble.common.redis"
		}
)
@MapperScan(basePackageClasses = {SsoMapperScanMarker.class})
public class ItodoubleSsoWebApp {
	public static void main(String[] args) {
		SpringApplication.run(ItodoubleSsoWebApp.class);
	}

	@RequestMapping(value = "")
	public RestResult index(){
		return RestResult.success();
	}
}
