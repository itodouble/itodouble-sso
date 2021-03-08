package top.itodouble.sso.apiService;

public interface SsoRedisServiceApi {
    String get(String key);

    boolean set(String key, String value);

    boolean set(String key, String value, long time);

    boolean expire(String key, long time);

    /**
     * 存放redis前先判断 shiro.token.access.expire.redisFlag 是否为true
     *
     * @param key
     * @param value
     * @return
     */
    boolean setAndCheckExpireFlag(String key, String value);

    boolean authenticationExpire(String username);
}
