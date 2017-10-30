package com.ucsmy.ucas.manage.service.impl;

import com.ucsmy.ucas.config.RedisConfig;
import com.ucsmy.ucas.manage.service.SysCacheService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class SysCacheServiceImpl implements SysCacheService {

    @Resource(name = "jsonRedisTemplate")
    private RedisConfig.JsonRedisTemplate redisTemplate;

    @Resource(name = "jsonRedisTemplate")
    private ValueOperations<String, Object> valueOperations;

    @Override
    public void set(String key, Object value) {
        valueOperations.set(key, value);
    }

    @Override
    public void set(String key, Object value, long invalid) {
        valueOperations.set(key, value, invalid, TimeUnit.SECONDS);
    }

    @Override
    public <T> T get(String key) {
        return (T) valueOperations.get(key);
    }

    @Override
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    @Override
    public long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    @Override
    public boolean expire(String key, long invalid) {
        return redisTemplate.hasKey(key);
    }

    @Override
    public void lPush(String channel, Object message) {
        redisTemplate.opsForList().leftPush(channel, message);
    }

    @Override
    public void lSetPush(String channel, Object message) {
        redisTemplate.opsForSet().add(channel, message);
    }

    @Override
    public long incr(String key) {
        return valueOperations.increment(key, 1);
    }

    @Override
    public long incr(String key, long invalid) {
        long value = valueOperations.increment(key, 1);
        this.expire(key, invalid);
        return value;
    }
}
