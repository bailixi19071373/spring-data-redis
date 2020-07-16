package com.mtw.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Redis数据库配
 * @author 
 *
 */
@Configuration
@PropertySource({"classpath:redis.properties"})
public class RedisConfig {
	@Value("${redis.host}")
	private String hostName;
	@Value("${redis.port}")
	private int port;
	@Value("${redis.password}")
	private String password;
	@Value("${redis.dbIndex}")
	private int dbIndex;
	
	@Bean//Redis密码
	public RedisPassword redisPassword() {
		return RedisPassword.of(password);
	}
	/**
	 * RedisStandaloneConfiguration 
	 * RedisSentinelConfiguration 
	 * RedisClusterConfiguration  
	 * @param redisPassword 
	 * @return
	 */
	@Bean// Redis配置(用户名密码数据库)
	public RedisStandaloneConfiguration redisStandaloneConfiguration(RedisPassword redisPassword) {
		RedisStandaloneConfiguration rsc = new RedisStandaloneConfiguration(hostName,port);
		rsc.setPassword(redisPassword);
		rsc.setDatabase(dbIndex);
		return rsc;
	}
	
	@Bean//Redis连接工厂 s使用Jedis连接
   public RedisConnectionFactory redisConnectionFactory(RedisStandaloneConfiguration redisStandaloneConfiguration) {
	   return new JedisConnectionFactory(redisStandaloneConfiguration);
   }
	
	@Bean//通用型操作模
	public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory
			){
		RedisTemplate<String,Object> redis = new RedisTemplate<>();
		redis.setKeySerializer(RedisSerializer.string());
		//使用JSON序列化器
		redis.setValueSerializer(RedisSerializer.json());
		redis.setHashKeySerializer(RedisSerializer.string());
		redis.setHashValueSerializer(RedisSerializer.json());
		redis.setConnectionFactory(redisConnectionFactory);
		redis.afterPropertiesSet();
		return redis;
	}
    
}
