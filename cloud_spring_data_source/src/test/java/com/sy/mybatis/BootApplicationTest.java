package com.sy.mybatis;

import com.sy.mybatis.entity.XbUsers;
import com.sy.mybatis.mapper1.User1Mapper;
import com.sy.mybatis.mapper2.User2Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author siyuan
 * @version 2.0
 * @date 2020/1/12 11:37
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BootApplicationTest {

    @Autowired
    User1Mapper usersMapper1;

    @Autowired
    User2Mapper usersMapper2;

    @Test
    public void getUsers(){
        List<XbUsers> xbUsers1 = usersMapper1.selectByMobile("18255436560");
        System.out.println("xbUsers1 = " + xbUsers1);
        List<XbUsers> xbUsers2 = usersMapper2.selectByMobile("18255436560");
        System.out.println("xbUsers2 = " + xbUsers2);
    }
}
