package com.mtw.config;

import java.time.Duration;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
/**
 * 注册缓存
 * @author 
 *
 */
@Configuration
@EnableCaching
public class CacheConfig {
	@Value("${redis.expire.seconds}")
	private long expireSeconds;
	@Inject
	private RedisConnectionFactory redisConnectionFactory;
	
	@Bean 
	public CacheManager cacheManager() {
        RedisCacheConfiguration redisCacheConfiguration=RedisCacheConfiguration.defaultCacheConfig().
                disableCachingNullValues().entryTtl(Duration.ofSeconds(expireSeconds)).
                serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.string())).
                serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.json()));
        RedisCacheWriter cacheWriter=RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory);
        RedisCacheManager redisCacheManager=new RedisCacheManager(cacheWriter,redisCacheConfiguration);
        return  redisCacheManager;
	}
}
