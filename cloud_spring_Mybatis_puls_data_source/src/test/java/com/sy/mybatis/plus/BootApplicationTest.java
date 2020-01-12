package com.sy.mybatis.plus;

import com.sy.mybatis.plus.entity.User;
import com.sy.mybatis.plus.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author siyuan
 * @version 2.0
 * @date 2020/1/12 13:36
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BootApplicationTest {
    @Autowired
    UserMapper xbUserMapper;

    @Test
    public void getUser(){
        List<User> xbUsers1 = xbUserMapper.selectByMobile1();
        System.out.println("xbUsers1 = " + xbUsers1);
        List<User> xbUsers2= xbUserMapper.selectByMobile2();
        System.out.println("xbUsers2 = " + xbUsers2);
    }
}
