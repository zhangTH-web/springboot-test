package com.xino.controller;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xino.dao.mybatis.StudentMapper;
import com.xino.dao.mybatis.bean.Student;

@RestController
@RequestMapping("test")
public class TestController {
	  
	@Resource
	StudentMapper studentDao;
	
	
	
	@RequestMapping("")
	public String name() {
		 Subject subject = SecurityUtils.getSubject();
	        String str="";
	        if(subject.hasRole("admin")){
	            str=str+"您拥有 admin 权限";
	        }else{
	            str=str+"您没有 admin 权限";
	        }
	        if(subject.hasRole("sale")){
	            str=str+"您拥有 sale 权限";
	        }
	        else{
	            str=str+"您没有 sale 权限";
	        }
	        try{
	            subject.checkPermission("app:setting:setting");
	            str=str+"您拥有 app:setting:setting 权限";

	        }catch (UnauthenticatedException ex){
	            str=str+"您没有 app:setting:setting 权限";
	        }
	        return  str;
//		return "sfafda";
	}
	@RequestMapping("haha")
	public String  testMybatis(int id){
		System.err.println(id);
		Student student = new  Student();
		student.setSbirthday(new Date());
		student.setSname("hehe");
		Student key = studentDao.selectByPrimaryKey(new Integer(id));
		return key.toString();
		
	}

}
