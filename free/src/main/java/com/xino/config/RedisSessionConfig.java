package com.xino.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 3600)////spring在多长时间后强制使redis中的session失效,默认是1800.(单位/秒)
public class RedisSessionConfig {

}
