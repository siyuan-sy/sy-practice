package com.sy.quartz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sy.quartz.entity.QuartzEntity;
import com.sy.quartz.entity.Result;
import com.sy.quartz.mapper.JobMapper;
import com.sy.quartz.service.IJobService;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
/**
 * @author siyuan
 * @version V1.0
 * @date 2020/9/30 10:32
 * @Copyright 合肥正恩有限公司
 */
@Service("jobService")
public class JobServiceImpl implements IJobService {

	@Resource
	private JobMapper mapper;
    @Autowired
    private Scheduler scheduler;

	@Override
	public Result list(QuartzEntity quartz) throws SchedulerException {
        List<QuartzEntity> list = null;
        Integer count = mapper.selectCount(new QueryWrapper<QuartzEntity>().last(!StringUtils.isEmpty(quartz.getJobName()),"WHERE job.JOB_NAME = "+quartz.getJobName()));
        if(count>0){
            QueryWrapper<QuartzEntity> query = new QueryWrapper<>();
            query.eq("1",1);
            if(!StringUtils.isEmpty(quartz.getJobName())){
                query.last(" and  job.JOB_NAME = #{"+quartz.getJobName()+"}");
            }
            list = mapper.list(query);
            for (QuartzEntity quartzEntity : list) {
                JobKey key = new JobKey(quartzEntity.getJobName(), quartzEntity.getJobGroup());
                JobDetail jobDetail = scheduler.getJobDetail(key);
                quartzEntity.setJobMethodName(jobDetail.getJobDataMap().getString("jobMethodName"));
            }
        }
        return Result.ok(list);
	}

	@Override
	public Long listQuartzEntity(QuartzEntity quartz) {
		return mapper.listCount();
	}

    @Override
    @Transactional
    public void save(QuartzEntity quartz) throws Exception{
        //如果是修改  展示旧的 任务
        if(quartz.getOldJobGroup()!=null){
            JobKey key = new JobKey(quartz.getOldJobName(),quartz.getOldJobGroup());
            scheduler.deleteJob(key);
        }
        Class cls = Class.forName(quartz.getJobClassName()) ;
        cls.newInstance();
        //构建job信息
        JobDetail job = JobBuilder.newJob(cls).withIdentity(quartz.getJobName(),
                quartz.getJobGroup())
                .withDescription(quartz.getDescription()).build();
        job.getJobDataMap().put("jobMethodName", quartz.getJobMethodName());
        // 触发时间点
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(quartz.getCronExpression());
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger"+quartz.getJobName(), quartz.getJobGroup())
                .startNow().withSchedule(cronScheduleBuilder).build();
        //交由Scheduler安排触发
        scheduler.scheduleJob(job, trigger);
    }
}
