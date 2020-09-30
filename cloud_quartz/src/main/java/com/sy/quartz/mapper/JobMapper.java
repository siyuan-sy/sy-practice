package com.sy.quartz.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sy.quartz.entity.QuartzEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author siyuan
 * @version V1.0
 * @Package com.sy.quartz.mapper
 * @date 2020/9/30 9:56
 * @Copyright 合肥正恩有限公司
 */
@Mapper
public interface JobMapper extends BaseMapper {
    List<QuartzEntity>  list (@Param("ew") QueryWrapper<QuartzEntity> ew);

    @Select("SELECT\n" +
            "\tCOUNT( * ) \n" +
            "FROM\n" +
            "\tQRTZ_JOB_DETAILS AS job\n" +
            "\tLEFT JOIN QRTZ_TRIGGERS AS tri ON job.JOB_NAME = tri.JOB_NAME\n" +
            "\tLEFT JOIN QRTZ_CRON_TRIGGERS AS cron ON cron.TRIGGER_NAME = tri.TRIGGER_NAME \n" +
            "WHERE\n" +
            "\ttri.TRIGGER_TYPE = 'CRON'")
    Long listCount();
}
