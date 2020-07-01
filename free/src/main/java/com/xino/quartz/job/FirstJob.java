package com.xino.quartz.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.xino.dao.mybatis.StudentMapper;
import com.xino.dao.mybatis.bean.Student;

public class FirstJob extends QuartzJobBean{
  
	  @Resource
	  StudentMapper StudentMapper;
	
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		
		System.err.println("hello!: "+arg0.getJobDetail().getKey());
	    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("QuartzJob1----" + sdf.format(new Date()));
        
        
        Student  stu = new Student();
        stu.setSbirthday(new Date());
        stu.setSname("wangwu");
        stu.setSno("123456");
        stu.setSsex("男");
        stu.setId(456);
//        stu.set
//        StudentMapper.selectByPrimaryKey(1);
//        System.out.println("===========");
//        StudentMapper.insert(stu);
		
	}

}
