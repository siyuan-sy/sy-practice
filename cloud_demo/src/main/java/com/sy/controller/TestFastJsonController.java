package com.sy.controller;

import com.alibaba.fastjson.JSON;
import com.sy.common.Message;
import com.sy.entity.EducationTrainInfoDto;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author siyuan
 * @create 2020/7/3
 */
@RequestMapping("/json")
@RestController
public class TestFastJsonController {

    @PostMapping("/parseObject")
    public Message  parseObject(@RequestBody String params){
        EducationTrainInfoDto educationTrainInfoDto = JSON.parseObject(params, EducationTrainInfoDto.class);
        return  Message.initial().addData("data",educationTrainInfoDto);
    }
}
