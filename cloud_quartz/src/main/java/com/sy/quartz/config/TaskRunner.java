package com.sy.quartz.config;

import com.sy.quartz.entity.QuartzEntity;
import com.sy.quartz.service.IJobService;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


/**
 * @author siyuan
 * @version V1.0
 * @date 2020/9/30 10:32
 * @Copyright 合肥正恩有限公司
 */
@Component
public class TaskRunner implements ApplicationRunner {
    
	private final static Logger LOGGER = LoggerFactory.getLogger(TaskRunner.class);
	
	@Autowired
    private IJobService jobService;
	@Autowired
    private Scheduler scheduler;
	
	@Override
    public void run(ApplicationArguments var) throws Exception{
        /**
         * 系统启动的时候会初始化一个任务
         */
        Long count = jobService.listQuartzEntity(null);
        if(count==0){
            LOGGER.info("初始化测试任务");
            QuartzEntity quartz = new QuartzEntity();
            quartz.setJobName("test01");
            quartz.setJobGroup("test");
            quartz.setDescription("测试任务");
            quartz.setJobClassName("com.itstyle.quartz.job.ChickenJob");
            quartz.setCronExpression("*/5 * * * * ?");
            quartz.setJobMethodName("test1");
            Class cls = Class.forName(quartz.getJobClassName()) ;
            cls.newInstance();
            //构建job信息
            JobDetail job = JobBuilder.newJob(cls).withIdentity(quartz.getJobName(),
                    quartz.getJobGroup())
                    .withDescription(quartz.getDescription()).build();
            job.getJobDataMap().put("jobMethodName", "test1");
            // 触发时间点
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(quartz.getCronExpression());
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger"+quartz.getJobName(), quartz.getJobGroup())
                    .startNow().withSchedule(cronScheduleBuilder).build();
            //交由Scheduler安排触发
            scheduler.scheduleJob(job, trigger);
        }
    }

}