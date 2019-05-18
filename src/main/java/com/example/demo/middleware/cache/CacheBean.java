package com.example.demo.middleware.cache;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.time.Duration;

import static java.util.Collections.singletonMap;

@Configuration
public class CacheBean extends CachingConfigurerSupport {

    @Bean
    CacheManager getCacheManager(RedisConnectionFactory connectionFactory) {

        /* 默认配置， 默认超时时间为30s */
        RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration
                .ofSeconds(30L)).disableCachingNullValues();

        /* 配置test的超时时间为120s*/
        RedisCacheManager cacheManager = RedisCacheManager.
                builder(RedisCacheWriter.lockingRedisCacheWriter(connectionFactory)).
                cacheDefaults(defaultCacheConfig).
                withInitialCacheConfigurations(
                        singletonMap(
                                "test", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(120L))
                        .disableCachingNullValues())).transactionAware().build();

        return cacheManager;
    }



}
