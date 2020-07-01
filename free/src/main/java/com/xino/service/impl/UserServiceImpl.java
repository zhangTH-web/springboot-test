package com.xino.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.xino.dao.mybatis.bean.Student;
import com.xino.service.UserService;

//fpcache 对应 ehcache.xml 中的 fpcache 节点
@CacheConfig(cacheNames = {"fpcache"})
@Service
public class UserServiceImpl implements UserService{

	  @Override
	    @Cacheable("fpcache")
	    public List<Student> list() {
	        List<Student> list=new ArrayList<>();
//	        list.add( new Student("fishpro","123456","11545"));
//	        list.add(new Student("fishpro","123456","11545"));
//	        list.add(new Student("fishpro","123456","11545"));
	        System.out.println("获取用户列表使用 @Cacheable 注意执行第二次的时候不会有本语句输出了，部分删除掉缓存");
	        return list;
	    }

	    @Override
	    @Cacheable(value = "fpcache",key = "#id")
	    public Student get(Integer id) {
	        System.out.println("获取单个用户 get user by"+id);
//	        return new Student("fishpro","123456","11545");
	        return new Student();

	    }

	    @Override
	    @CachePut(value = "fpcache",key = "#user.id")
	    public Student save(Student user) {
	        System.out.println("保存用户使用 @CachePut 每次都会执行语句并缓存 save user by "+user.getSname());
	        return user;

	    }

	    @Override
	    @CachePut(value = "fpcache",key = "#user.id")
	    public Student update(Student user) {
	        System.out.println("更新用户使用 @CachePut 每次都会执行语句并缓存 update user by "+user.getSname());
	        return user;

	    }

	    @Override
	    @CacheEvict(allEntries = true)
	    public void delete(Integer id) {
	        System.out.println("删除用户根据用户ID，如果 allEntries = true 则不论 key 是啥都全部删除缓存"+id);
	    }

}
