package com.shzhong.mqorder.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
@EnableRedisHttpSession
public class RedisSessionConfig {
    public RedisSessionConfig() {
        // TODO Auto-generated constructor stub
    }

}
