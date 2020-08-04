package com.sy.mybatis.plus.test;

import com.sy.mybatis.plus.entity.User;
import com.sy.mybatis.plus.mapper.UserMapper;
import com.sy.mybatis.plus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author siyuan
 * @version 2.0
 * @date 2020/1/12 13:34
 */
@RestController
@RequestMapping("/test")
public class TestController {

   @Autowired
   UserService userService;

    @GetMapping("/")
    public Object getUser(){
        Object user = userService.getUser();

        return user;
    }
}
