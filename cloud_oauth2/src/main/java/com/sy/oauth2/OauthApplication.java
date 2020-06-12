package com.sy.oauth2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author siyuan
 * @create 2020/6/11
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.sy.oauth2.mapper")
public class OauthApplication {

    public static void main(String[] args) {
        SpringApplication.run(OauthApplication.class);
    }
}
