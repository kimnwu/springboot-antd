package com.ucsmy.ucas.manage.service;

/**
 * Created by ucs_zhongtingyuan on 2017/4/11.
 */
public interface SysCacheService {
    void set(String key, Object value);

    void set(String key, Object value, long invalid);

    <T> T get(String key);

    // 删除对应缓存数据
    void delete(String key);

    //查询key是否存在
    boolean hasKey(String key);

    //获取key过期时间
    long getExpire(String key);

    boolean expire(String key, long invalid);

    void lPush(String channel, Object message);

    void lSetPush(String channel, Object message);

    long incr(String key);

    long incr(String key, long invalid);
}
