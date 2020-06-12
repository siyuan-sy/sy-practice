package com.sy.swagger;


import com.sy.swagger.config.IgnoreClientProperties;
import com.sy.swagger.config.userClientProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
@RestController
public class SwaggerApplication {

    @Value("${auth.skip.urls}")
    private String[] skipAuthUrls;


    @GetMapping("/hello")
    public Object hello() {
        userClientProperties userClientProperties = new userClientProperties();
        List<String> clients = userClientProperties.getUrls();
        clients.stream().forEach(x->System.out.println(x));
        IgnoreClientProperties ignoreClientProperties = new IgnoreClientProperties();
        return ignoreClientProperties.getClients();
    }


    @GetMapping("/test")
    public Object test() {

        return StringUtils.join(skipAuthUrls);
    }



    public static void main(String[] args) {
        SpringApplication.run(SwaggerApplication.class);
    }
}
