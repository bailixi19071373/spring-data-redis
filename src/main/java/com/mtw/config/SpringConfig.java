package com.mtw.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration//≈‰÷√
@ComponentScan("com.mtw")//…®√Ëƒ«–©∞¸
@PropertySource("classpath:redis.properties")
@Import({RedisConfig.class})
public class SpringConfig {
			
}
