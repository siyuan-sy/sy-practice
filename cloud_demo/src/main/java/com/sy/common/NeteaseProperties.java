package com.sy.common;

import lombok.Data;

/**
 * @ClassName NeteaseProperties
 * @Description
 * @Author DINGLAN
 * @Date 2019/4/30 14:56
 **/
@Data
public class NeteaseProperties {
    private boolean switchon;
    private String appKey;
    private String appSecret;
    private String sendtemplate;
    private String sendcode;
    private String verifycode;
    private String testTemplate;
    private String firstTemplate;
    private String secondTemplate;
    private Long secondInterval;
    private Integer limitMobile;
}
