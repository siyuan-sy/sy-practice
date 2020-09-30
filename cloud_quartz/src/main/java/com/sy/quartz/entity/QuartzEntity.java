package com.sy.quartz.entity;

import lombok.Data;


/**
 * @author siyuan
 * @version V1.0
 * @date 2020/9/30 10:32
 * @Copyright 合肥正恩有限公司
 */
@Data
public class QuartzEntity{

    private String jobName;//任务名称
    private String jobGroup;//任务分组
    private String description;//任务描述
    private String jobClassName;//执行类
    private String jobMethodName;//执行方法
    private String cronExpression;//执行时间
    private String triggerName;//执行时间
    private String triggerState;//任务状态

    private String oldJobName;//任务名称 用于修改
    private String oldJobGroup;//任务分组 用于修改
}
