package com.ucsmy.ucas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * redis配置
 * Created by ucs_zhongtingyuan on 2017/4/11.
 */
@Configuration
public class RedisConfig {

    @Bean(name = "jsonRedisTemplate")
    public RedisOperations<Object, Object> jsonRedisTemplate(RedisConnectionFactory connectionFactory) {
        return new JsonRedisTemplate(connectionFactory);
    }

    public static class JsonRedisTemplate extends RedisTemplate<Object, Object> {

        JsonRedisTemplate() {
            RedisSerializer<String> stringSerializer = new StringRedisSerializer();
            GenericJackson2JsonRedisSerializer jsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
            setKeySerializer(stringSerializer);
            setValueSerializer(jsonRedisSerializer);
            setHashKeySerializer(stringSerializer);
            setHashValueSerializer(jsonRedisSerializer);
        }

        JsonRedisTemplate(RedisConnectionFactory connectionFactory) {
            this();
            setConnectionFactory(connectionFactory);
            afterPropertiesSet();
        }

    }
}
