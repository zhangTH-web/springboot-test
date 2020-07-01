package com.xino.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xino.quartz.service.QuartzService;

@RestController
@RequestMapping("quartz")
public class QuartzController {

	  @Autowired  
	  QuartzService quartzService;
	  
	  @RequestMapping("delete")
	  public String  delete(HttpServletRequest  request ){
		  
		  String  jobName  = request.getParameter("jobName");
		  System.err.println(jobName);
		  
		  quartzService.delJob("myJob1", "myJobGroup1");
		  return "success";
	  }
	
}
