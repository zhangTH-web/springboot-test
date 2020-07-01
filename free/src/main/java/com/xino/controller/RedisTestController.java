package com.xino.controller;

import javax.annotation.Resource;

import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xino.dao.mybatis.bean.Student;
import com.xino.service.UserService;

@RestController
@RequestMapping("redis")
public class RedisTestController {
	
	  @Resource 
	  UserService userService;
   
	  @GetMapping("/test")
	    public String testCache(){
		  ClassLoader  classLoader = new ClassLoader() {
		};
	        System.out.println("============以下第一次调用 ================");
	        userService.list();
	        userService.get(1);
	        
//	        userService.save(new Student("fishpro","123456","hah"));
	       // userService.update(new Student("fishpro","123456434","hah"));

	        System.out.println("============以下第二次调用 观察 list 和 get 方法 ================");

	        userService.list();
	        userService.get(1);
//	        userService.save(new Student("fishpro","123456","hah"));
	        //userService.update(new Student(1,"fishpro","123456434","hah"));


	        System.out.println("============以下第三次调用 先删除 观察 list 和 get 方法 ================");
	        userService.delete(1);
	        userService.list();
	        userService.get(1);
//	        userService.save(new Student("fishpro","123456","hah"));
	      //  userService.update(new Student("fishpro","123456434","hah"));
	        return  "";
	    }
}
