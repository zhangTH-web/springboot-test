package com.xino.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableRedisHttpSession
@RequestMapping("shareSession")
public class RedisSessionShareController {

	@RequestMapping("test")   
	public String test(HttpServletRequest  request){
		
		request.getSession().setAttribute("username", "session共享测试");
		 request.getSession().setMaxInactiveInterval(10*1000);
		 
		 String username = (String)request.getSession().getAttribute("username");

	       return "username"+username+ " session_id:"+request.getSession().getId();
		
		
	}
}
