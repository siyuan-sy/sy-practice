package com.sy.mybatis.plus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
@Data
@TableName("test_user")
public class User {
    private int id;
    private String name;
    private int age;
}