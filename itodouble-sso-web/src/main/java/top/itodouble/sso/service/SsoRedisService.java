package top.itodouble.sso.service;

import top.itodouble.redis.service.RedisService;
import top.itodouble.sso.enums.RedisKeyPrefixEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SsoRedisService {
	@Value("${shiro.token.access.expire.redisFlag}")
	private Boolean accessTokenExpireRedisFlag;
	@Value("${shiro.token.access.expire.redisTime}")
	private Long accessTokenExpireRedisTime;

	@Autowired
	private RedisService redisService;

	public String get(String key) {
		return (String) redisService.get(key);
	}

	public boolean set(String key, String value) {
		return redisService.set(key, value);
	}

	public boolean set(String key, String value, long time) {
		return redisService.set(key, value, time);
	}

	public boolean expire(String key, long time) {
		return redisService.expire(key, time);
	}

	/**
	 * 判断 shiro.token.access.expire.redisFlag
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean setAndCheckExpireFlag(String key, String value) {
		if (accessTokenExpireRedisFlag) {
			return redisService.set(key, value, accessTokenExpireRedisTime);
		}
		return redisService.set(key, value);
	}

	public boolean authenticationExpire(String username) {
		if (accessTokenExpireRedisFlag) {
			redisService.expire(RedisKeyPrefixEnum.SsoUserToken.getSn() + username, accessTokenExpireRedisTime);
			redisService.expire(RedisKeyPrefixEnum.SsoSystemUserRole.getSn() + username, accessTokenExpireRedisTime);
			redisService.expire(RedisKeyPrefixEnum.SsoSystemUserMenu.getSn() + username, accessTokenExpireRedisTime);
		}
		return true;
	}

	public void delUserInfo(String username) {
		redisService.del(
				RedisKeyPrefixEnum.SsoUserToken.getSn() + username
				, RedisKeyPrefixEnum.SsoSystemUserRole.getSn() + username
				,RedisKeyPrefixEnum.SsoSystemUserMenu.getSn() + username
		);
	}

	public void del(String... key){
		redisService.del(key);
	}
}
