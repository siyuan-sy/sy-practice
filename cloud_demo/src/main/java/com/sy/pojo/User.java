package com.sy.pojo;

import cn.hutool.core.clone.CloneSupport;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends CloneSupport implements Serializable {

    private String name;
    private Integer age;
    private List<Rol> rol;

    public String testMethod(){
        return "test for " + this.name;
    }

}
