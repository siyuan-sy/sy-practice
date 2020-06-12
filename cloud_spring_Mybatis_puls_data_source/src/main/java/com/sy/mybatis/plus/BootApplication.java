package com.sy.mybatis.plus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author siyuan
 * @version 2.0
 * @date 2020/1/12 13:06
 */
@SpringBootApplication
@MapperScan("com.sy.mybatis.plus.mapper")
public class BootApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class);
    }
}
