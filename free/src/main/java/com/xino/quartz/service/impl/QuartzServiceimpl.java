package com.xino.quartz.service.impl;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
//import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import com.xino.quartz.service.QuartzService;
@Service
public class QuartzServiceimpl implements QuartzService{
	    @Autowired
	    private Scheduler scheduler; // 在SchedulerConfig配置类中  已经由Spring管理，所以这里可以自动注入

      /**
	　　* jobName    任务名 自定义
	　　* jobGroup   任务组 自定义
	　　* cron　　    时间表达式
	　　* jobClass   任务实现类   如 StartUserJob 或  CloseUserJob
	　　* jobDataMap 自定义参数   
	　　**/

	    // 添加定时任务
	    @Override
	    public void addJob(String jobName, String jobGroup, String cron, Class<? extends QuartzJobBean> jobClass, JobDataMap jobDataMap) {
	        try {
	            /**
	             *  构建JobDetail (表示一个具体的可执行的调度程序，Job是这个可执行调度程序所要执行的内容)
	             */
	            JobDetail jobDetail = JobBuilder.newJob(jobClass)
	                    .withIdentity(jobName,jobGroup)
	                    .usingJobData(jobDataMap)
	                    .build();

	            /**
	             *  构建出发去Trigger （调度参数的配置，代表何时出发该任务)
	             */
	            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
	            CronTrigger trigger =  TriggerBuilder.newTrigger()
	                    .withIdentity(jobName,jobGroup)
	                    .startNow()
	                    .withSchedule(scheduleBuilder)
	                    .build();
	            scheduler.scheduleJob(jobDetail, trigger);
	            scheduler.start();
	            System.out.println("添加定时任务成功");
	        } catch (SchedulerException e) {
	            e.printStackTrace();
	        }

	    }

	    // 删除定时任务
	    @Override
	    public void delJob(String jobName, String jobGroup) {

	        try {
	            // TriggerKey 定义了trigger的名称和组别 ，通过任务名和任务组名获取TriggerKey
	            TriggerKey triggerKey = TriggerKey.triggerKey(jobName,jobGroup);
	            // 停止触发器
	            scheduler.resumeTrigger(triggerKey);
	           // 移除触发器
	            scheduler.unscheduleJob(triggerKey);
	            // 移除任务
	            scheduler.deleteJob(JobKey.jobKey(jobName,jobGroup));
	            System.out.println("删除定时任务成功");
	        } catch (SchedulerException e) {
	            e.printStackTrace();
	        }

	    }

	    // 暂停定时任务
	    @Override
	    public void pauseJob(String jobName, String jobGroup) {

	        try {
	            JobKey jobKey = JobKey.jobKey(jobName,jobGroup);
	            // 暂停任务
	            scheduler.pauseJob(jobKey);

	            System.out.println("暂停定时任务成功");
	        } catch (SchedulerException e) {
	            e.printStackTrace();
	        }

	    }

	    // 继续定时任务
	    @Override
	    public void resumeJob(String jobName, String jobGroup) {

	        try {
              // 通过任务名和任务组名获取jobKey
	            JobKey jobKey = JobKey.jobKey(jobName,jobGroup);
	            // 继续任务
	            scheduler.resumeJob(jobKey);
	            System.out.println("继续定时任务成功");
	        } catch (SchedulerException e) {
	            e.printStackTrace();
	        }

	    }
}
