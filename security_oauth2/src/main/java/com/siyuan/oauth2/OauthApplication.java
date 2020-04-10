package com.siyuan.oauth2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.siyuan.oauth2.mapper")
public class OauthApplication {
    public static void main(String[] args) {
        SpringApplication.run(OauthApplication.class);
    }
}
