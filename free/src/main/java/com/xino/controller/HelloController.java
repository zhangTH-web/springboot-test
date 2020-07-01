package com.xino.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {
	   
	
       @RequestMapping("/test")
       @ResponseBody
	   public String name() {
		   
		   return  "运行成功";
	}
}
