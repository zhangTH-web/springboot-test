package com.xino.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    //shiro 认证成功后默认跳转页面
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/403")
    public String err403(){
        return "403";
    }
    /**
     * 根据权限授权使用注解 @RequiresPermissions
     * */
    @GetMapping("/article")
    @RequiresPermissions("app:article:article")
    public String article(){
        return "article";
    }

    /**
     * 根据权限授权使用注解 @RequiresPermissions
     * */
    @GetMapping("/setting")
    @RequiresPermissions("app:setting:setting")
    public String setting(){
        return "setting";
    }

    @GetMapping("/show")
    @RequiresPermissions("app:article:article")
    @ResponseBody
    public String show(){

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
    }

    //get /login 方法，对应前端 login.html 页面
    @GetMapping("/login")
    public String login(){
    	Subject subject = SecurityUtils.getSubject();
    	Session session = subject.getSession();
    	
    	if(session.getAttribute("userName")!=null){
    		System.err.println("=========");
    		return "redirect:/index";
    	}
    	 
        return "login";
    }

    //post /login 方法，对应登录提交接口
    @PostMapping("/login")
    @ResponseBody
    public Object loginsubmit(@RequestParam String userName,@RequestParam String password){
        Map<String,Object> map=new HashMap<>();
        //把身份 useName 和 证明 password 封装成对象 UsernamePasswordToken
        UsernamePasswordToken token=new UsernamePasswordToken(userName,password);
        //获取当前的 subject 
//        使用SecurityUtils。getSubject()，我们可以获得当前正在执行的Subject。一个subject就是一个应用程序的用户的安全，具体的“视图”。我们实际上想将其称为“用户”，因为那“很合理”，但我们决定反对：太多的应用程序具有已经具有自己的用户类/框架的现有API，并且我们不想与它们发生冲突。同样，在安全领域，该术语Subject实际上是公认的术语。好吧，继续...
//        getSubject()独立应用程序中的调用可能会Subject在特定于应用程序的位置中返回基于用户数据的，而在服务器环境（例如Web应用程序）中，它会获取Subject与当前线程或传入请求相关联的基于用户数据的。
//        现在您有了Subject，您可以使用它做什么？
//        如果要在用户与应用程序的当前会话期间使事情可用，则可以获取他们的会话：
//        Session session = currentUser.getSession();
       
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(token);
            subject.getSession().setAttribute( "userName", "userName" );
            map.put("status",0);
            map.put("message","登录成功");
            return map;
        }catch (AuthenticationException e){
            map.put("status",1);
            map.put("message","用户名或密码错误");
            return map;
        }
    }


    @GetMapping("/logout")
    String logout(HttpSession session, SessionStatus sessionStatus, Model model) {
        //会员中心退出登录 当使用这两属性session属性退出
        session.removeAttribute("userData");
        sessionStatus.setComplete();
        SecurityUtils.getSubject().logout();
        return "redirect:/login";

    }
}
