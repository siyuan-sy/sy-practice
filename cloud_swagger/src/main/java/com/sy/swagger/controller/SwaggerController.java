package com.sy.swagger.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/swagger")
public class SwaggerController {

    @ApiOperation(value = "思源",httpMethod = "GET",response = Object.class)
    @ApiImplicitParam(name = "siyuan",value = "思源",required = false, dataType = "Integer", paramType = "query")
    @GetMapping("/test")
    public Object test(){
        return  "siyuan";
    }


}
