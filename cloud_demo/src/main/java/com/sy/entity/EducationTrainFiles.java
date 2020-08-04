package com.sy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 教育培训附件(EducationTrainFiles)实体类
 *
 * @author makejava
 * @since 2020-06-16 13:56:59
 */
@Data
@AllArgsConstructor
public class EducationTrainFiles implements Serializable {
    private static final long serialVersionUID = 917068989628324616L;
    /**
    * 主键
    */
    private Long id;
    /**
    * 教育培训标识
    */
    private Long erId;
    /**
    * 附件
    */
    private String annexUrl;

}