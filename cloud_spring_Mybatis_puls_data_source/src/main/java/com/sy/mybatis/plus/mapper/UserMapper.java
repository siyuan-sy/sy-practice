package com.sy.mybatis.plus.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sy.mybatis.plus.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author siyuan
 * @version 2.0
 * @date 2020/1/12 13:05
 */
public interface UserMapper extends BaseMapper<User> {
    @DS("master")
    @Select("select name,age from test_user")
    List<User> selectByMobile1();


    @DS("slave_1")
    @Select("select name,age from test_user")
    List<User> selectByMobile2();
}
