package com.xino.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jboss.logging.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xino.vo.UserVo;

@Controller
@RequestMapping("login")
public class LoginController {
        

	
	@RequestMapping("login")
	public  String  goLoginPage(String userName,HttpSession httpSession ,HttpServletRequest request,UserVo userVos){
		System.err.println(userName);
		request.getAttribute("username");
		userName = request.getParameter("username");
		System.err.println(userName);
		LoginController.covertMap(request);
		 if("zh".equals(userName)){
			    UserVo  userVo = new UserVo();
			    userVo.setUserId("123");
			    userVo.setUserName("lisi");
			    httpSession.setAttribute("user", userVo);
//			    httpSession
			    return "index";
		 }else{
		     	 httpSession.invalidate();
	            return "login";
			 
		 }
	}
	
	@RequestMapping("page1")
	@ResponseBody
	public  ModelAndView  goLoginPage13(){
         
		return null;

	}
	
	/**
	 * 获取Request 参数值
	 * @param request
	 * @return
	 */
	public static Map covertMap(HttpServletRequest request){
		Map<String,String> map=new HashMap<String, String>();
		Enumeration<String> enums =request.getParameterNames();  
		while (enums.hasMoreElements()) {  
		  String paramName = (String) enums.nextElement();  
		  String paramValue = request.getParameter(paramName);  
		   //形成键值对应的map  
		  map.put(paramName, paramValue.trim());  
		}  
		System.err.println(map.toString());
		return map;
	}
	
	
	
}
