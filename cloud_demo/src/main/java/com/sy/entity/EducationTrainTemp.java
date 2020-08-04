package com.sy.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 培训人员临时信息(EducationTrainTemp)实体类
 *
 * @author makejava
 * @since 2020-06-16 13:57:07
 */
@Data
public class EducationTrainTemp implements Serializable {
    private static final long serialVersionUID = -14531098474738243L;

    /**
     * 主键
     */
    private Long id;
    /**
     * 姓名
     */
    @ExcelProperty("姓名")
    private String name;
    /**
     * 身份证号码
     */
    @ExcelProperty("身份证号")
    private String idNo;

    /**
     * 职务
     */
    @ExcelProperty("工作单位及职务")
    private String job;
    /**
     * 联系电话
     */
    @ExcelProperty("联系方式")
    private String phone;
    /**
     * 组织ID
     */
    private Long orgId;
    /**
     * 区域ID
     */
    private Long areaId;
    /**
     * 批次ID
     */
    private String batchId;

}