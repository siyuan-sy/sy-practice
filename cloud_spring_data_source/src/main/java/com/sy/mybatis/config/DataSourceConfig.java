package com.sy.mybatis.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
    @Bean(name = "dsTest1")
    @ConfigurationProperties(prefix = "spring.datasource.test1")
    DruidDataSource dsTest1() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "dsTest2")
    @ConfigurationProperties(prefix = "spring.datasource.test2")
    DruidDataSource dsTest2() {
        return DruidDataSourceBuilder.create().build();
    }

}