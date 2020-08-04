package com.sy.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 培训人员信息(EducationTrainPeople)实体类
 *
 * @author makejava
 * @since 2020-06-16 13:57:06
 */
@Data
@ApiModel("培训人员信息")
public class EducationTrainPeople implements Serializable {
    private static final long serialVersionUID = 807959705245135615L;
    /**
     * 主键
     */
    @ApiModelProperty("主键")
    private Long id;
    /**
     * 教育培训信息主键
     */
    @ApiModelProperty("教育培训信息主键")
    private Long erId;
    /**
     * 姓名
     */
    @ApiModelProperty("姓名")
    private String name;
    /**
     * 身份证号码
     */
    @ApiModelProperty(" 身份证号码")
    private String idNo;
    /**
     * 组织ID
     */
    @ApiModelProperty(" 组织ID")
    private Long orgId;
    /**
     * 区域ID
     */
    @ApiModelProperty("  区域ID")
    private Long areaId;

    /**
     * 职务
     */
    @ExcelProperty("工作单位及职务")
    private String job;
    /**
     * 联系电话
     */
    @ExcelProperty("联系电话")
    private String phone;
}