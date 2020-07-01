package com.xino.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.xino.intercepors.LoginInterceptor;

@Configuration
public class WebConfigurer implements WebMvcConfigurer{
    
	  private static final Logger logger= LoggerFactory.getLogger(WebConfigurer.class);
	  
    @Autowired
    private LoginInterceptor loginInterceptor;
//    springmvc的拦截器是优先级高于shiro的，shiro就是自定义实现了spring mvc的filte
    // 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		 // addPathPatterns("/**") 表示拦截所有的请求，
        // excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
		logger.debug("addInterceptors");
		 System.err.println("addInterceptors");
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/login/login");
//        super.addInterceptors(registry);    //较新Spring Boot的版本中这里可以直接去掉，否则会报错

	}
	  // 这个方法是用来配置静态资源的，比如html，js，css，等等
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}
	
	   @Override
	    public void addViewControllers(ViewControllerRegistry registry) {
		   System.err.println("addViewControllers");
	                registry.addViewController("/login.html").setViewName("login");
	           }

	
	 

}
