package com.sy.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2020-06-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class NationwideDict implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    private Integer xybz;

    /**
     * code的父id
     */
    private Long pcode;

    /**
     * 编码  对应  字典表编码  VALUE
     */
    private Long code;

    /**
     * boolean
     */
    private String disable;

    private Integer dm;

    /**
     * 名称  对应 字典表  NAME
     */
    private String caption;

    private Integer ordernum;

    private Integer ccm;

    private Integer yxbz;

    /**
     * 字典表字段 VALUE
     */
    @TableField("NAME")
    private String name;

    /**
     * 字典表字段 NAME
     */
    @TableField("VALUE")
    private String value;

    @TableField("PID")
    private Integer pid;


}
