package com.xino.quartz.config;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import com.xino.quartz.job.FirstJob;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {
	 @Bean
	  public  JobDetail  myJobDetail(){
//		 JobDetail jobDetail=JobBuilder.newJob(自己实例化的定时任务.class).withIdentity("任务名","组名").build();
		  JobDetail jobDetail = JobBuilder.newJob(FirstJob.class)
	                .withIdentity("myJob1","myJobGroup1")
	                //JobDataMap可以给任务execute传递参数
	                .usingJobData("job_param","job_param1")
	                .storeDurably()
	                .build();
	        return jobDetail;
	  }
	   //这种就是启动springboot就执行
	   @Bean
	    public Trigger myTrigger(){
	        Trigger trigger = TriggerBuilder.newTrigger()
	                .forJob(myJobDetail())
	                .withIdentity("myJob1","myJobGroup1")
	                .usingJobData("job_trigger_param","job_trigger_param1")
	                .startNow()
	                //.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever())
	                .withSchedule(CronScheduleBuilder.cronSchedule("0/30 * * * * ? 2020"))
	                .build();
	        return trigger;
	    }
	 

}
