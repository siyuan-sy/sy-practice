package com.sy.quartz.service;
import com.sy.quartz.entity.QuartzEntity;
import com.sy.quartz.entity.Result;
import org.quartz.SchedulerException;
/**
 * @author siyuan
 * @version V1.0
 * @date 2020/9/30 10:32
 * @Copyright 合肥正恩有限公司
 */
public interface IJobService {

    Result list(QuartzEntity quartz) throws SchedulerException;
    
    Long listQuartzEntity(QuartzEntity quartz);

    void save(QuartzEntity quartz) throws Exception;
}
