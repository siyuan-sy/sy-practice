package com.sy.oauth2.config;

import com.sy.oauth2.config.common.CustomAccessTokenConverter;
import com.sy.oauth2.config.common.ResourceAuthExceptionEntryPoint;
import com.sy.oauth2.handle.CustomAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter
{
    @Autowired
    private CustomAccessDeniedHandler accessDeniedHandler;

    @Autowired
    private ResourceAuthExceptionEntryPoint exceptionEntryPoint;



    /*@Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @PostConstruct
    public void initJwtConverter() {
        jwtAccessTokenConverter.setAccessTokenConverter(new CustomAccessTokenConverter());
    }*/


    @Override
    public void configure(HttpSecurity http) throws Exception
    {
       /* http.csrf().disable()
        .authorizeRequests().anyRequest().authenticated()
        .and()
        .httpBasic();*/
        http.authorizeRequests()
                .anyRequest().authenticated();
    }

/*

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate()
    {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler());
        return restTemplate;
    }
*/


    @Override
    public void configure(ResourceServerSecurityConfigurer resources)
    {
        resources.authenticationEntryPoint(exceptionEntryPoint).accessDeniedHandler(accessDeniedHandler);
    }
}
