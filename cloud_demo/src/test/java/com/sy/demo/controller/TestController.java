package com.sy.demo.controller;

import com.sy.mapper.EducationTrainTempMapper;
import com.sy.pojo.Temp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author siyuan
 * @create 2020/7/8
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestController {

    @Resource
    EducationTrainTempMapper educationTrainTempMapper;

    @Test
    public void getUser(){
        String str = "1,2,3,4";
        educationTrainTempMapper.tempinsert(str,",");
        List<Temp> temps = educationTrainTempMapper.tempList();
        System.out.println("temps = " + temps);
    }

}
