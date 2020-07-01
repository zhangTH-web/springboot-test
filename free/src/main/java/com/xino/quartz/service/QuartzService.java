package com.xino.quartz.service;

import org.quartz.JobDataMap;
import org.quartz.SchedulerException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public interface QuartzService {
	/**
	 * 添加定时任务  ，实现方式跟quartzConfig一致 ，就是变成手动去调用
	 */
	void addJob(String jobName, String jobGroup, String cron, Class<? extends QuartzJobBean> jobClass,
			JobDataMap jobDataMap) throws SchedulerException;

	/**
	 * 删除定时任务
	 */
	void delJob(String jobName, String jobGroup);

	/**
	 * 暂停定时任务
	 */
	void pauseJob(String jobName, String jobGroup);

	/**
	 * 继续定时任务
	 */
	void resumeJob(String jobName, String jobGroup);

}
