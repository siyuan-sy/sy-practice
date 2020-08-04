package com.sy.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 教育培训信息(EducationTrainInfo)实体类
 *
 * @author makejava
 * @since 2020-06-16 13:57:03
 */
@Data
public class EducationTrainInfo implements Serializable {
    private static final long serialVersionUID = 634257407275968117L;
    /**
    * 主键
    */
    private Long id;
    /**
    * 培训班名称
    */
    private String className;
    /**
    * 层级
    */
    private Long etLevel;
    /**
    * 培训开始时间
    */
    private Date startTime;
    /**
    * 培训结束时间
    */
    private Date endTime;
    /**
    * 主办单位
    */
    private String hostUnit;
    /**
    * 培训地点
    */
    private String address;
    /**
    * 培训人数
    */
    private Long trainNum;
    /**
    * 备注
    */
    private String remark;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 更新时间
    */
    private Date updateTime;
    /**
    * 创建人
    */
    private String createUser;
    /**
    * 更新人
    */
    private String updateUser;

    /**
     * 联系电话
     */
    private String politicsStatus ;

    /**
     * 工作单位及职务
     */
    private String job;
}