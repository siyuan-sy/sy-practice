package com.sy.pojo;

import cn.hutool.core.lang.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Lombok注解
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubPerson extends Person {
    public static final String SUBNAME = "TEST";

    private UUID id;
    private String subName;
    private Boolean isSlow;

    @Override
    public String toString() {
        return "SubPerson{" +
                "id=" + id +
                ", subName='" + subName + '\'' +
                ", isSlow=" + isSlow + super.toString()+
                '}';
    }
}