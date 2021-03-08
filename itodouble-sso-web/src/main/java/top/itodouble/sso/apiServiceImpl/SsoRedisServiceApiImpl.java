package top.itodouble.sso.apiServiceImpl;

import top.itodouble.sso.apiService.SsoRedisServiceApi;
import top.itodouble.sso.constant.FinanceSsoConst;
import top.itodouble.sso.service.SsoRedisService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Service(version = FinanceSsoConst.dubboVersion)
@Component
public class SsoRedisServiceApiImpl implements SsoRedisServiceApi {
	@Autowired
	private SsoRedisService ssoRedisService;

	@Override
	public String get(String key) {
		return ssoRedisService.get(key);
	}

	@Override
	public boolean set(String key, String value) {
		return ssoRedisService.set(key, value);
	}

	@Override
	public boolean set(String key, String value, long time) {
		return ssoRedisService.set(key, value, time);
	}

	@Override
	public boolean expire(String key, long time) {
		return ssoRedisService.expire(key, time);
	}

	@Override
	public boolean setAndCheckExpireFlag(String key, String value) {
		return ssoRedisService.setAndCheckExpireFlag(key, value);
	}

	@Override
	public boolean authenticationExpire(String username) {
		return ssoRedisService.authenticationExpire(username);
	}
}
