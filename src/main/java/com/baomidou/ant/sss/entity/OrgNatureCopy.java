package com.baomidou.ant.sss.entity;

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
public class OrgNatureCopy implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private Long pid;

    private Integer sort;


}
