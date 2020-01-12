package com.sy.mybatis.plus.test;

import com.sy.mybatis.plus.entity.User;
import com.sy.mybatis.plus.mapper.UserMapper;
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
    UserMapper xbUserMapper;

    @GetMapping("/")
    public Object getUser(){
        List<User> xbUsers1 = xbUserMapper.selectByMobile1();
        System.out.println("xbUsers1 = " + xbUsers1);
        List<User> xbUsers2= xbUserMapper.selectByMobile2();
        System.out.println("xbUsers2 = " + xbUsers2);
        return  xbUsers1 +"\n" + xbUsers2;
    }
}
