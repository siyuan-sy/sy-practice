package com.sy.excel.controller;

import com.excel.poi.ExcelBoot;
import com.excel.poi.entity.ErrorEntity;
import com.excel.poi.function.ImportFunction;
import com.sy.excel.pojo.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 导入Demo
 * <p>
 * UserEntity是标注注解的类, Excel的导入映射类, onProcess的userEntity参数则是Excel每行数据的映射实体
 * ErrorEntity是封装了每行Excel数据常规校验后的错误信息实体, 封装了sheet号、行号、列号、单元格值、所属列名、错误信息
 * <p>
 * onProcess方法是用户自己实现, 当经过正则或者判空常规校验成功后执行的方法, 参数是每行数据映射的实体
 * onError方法是用户自己实现, 当经过正则或者判空常规校验失败后执行的方法
 */
@Controller
@RequestMapping("/import")
public class TestController {
    @RequestMapping("/importExcel")
    public void importExcel(@RequestParam("file")MultipartFile file) throws IOException {
        ExcelBoot.ImportBuilder(file.getInputStream(), UserEntity.class)
                .importExcel(new ImportFunction<UserEntity>() {

                    /**
                     * @param sheetIndex 当前执行的Sheet的索引, 从1开始
                     * @param rowIndex 当前执行的行数, 从1开始
                     * @param userEntity Excel行数据的实体
                     */
                    @Override
                    public void onProcess(int sheetIndex, int rowIndex, UserEntity userEntity) {
                        //对每条数据自定义校验以及操作
                        System.out.println("userEntity = " + userEntity);
                        //分页插入：当读取行数到达用户自定义条数执行插入数据库操作
                    }

                    /**
                     * @param errorEntity 错误信息实体
                     */
                    @Override
                    public void onError(ErrorEntity errorEntity) {
                        //操作每条数据非空和正则校验后的错误信息
                    }
                });
    }
}