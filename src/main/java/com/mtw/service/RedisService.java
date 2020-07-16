package com.mtw.service;

import javax.inject.Inject;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;

@Service
public class RedisService {
	@Inject	
	private RedisTemplate redisTemplate;
	
	public void addString(String key,String value) {
		redisTemplate.opsForValue().set(key,value);
	  }
}
