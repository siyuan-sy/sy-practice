package com.sy.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @ClassName SbopConfig
 * @Description 项目自定义属性
 * @Author DINGLAN
 * @Date 2019/2/27 13:41
 **/
@Component
@Configuration
@ConfigurationProperties(prefix = "sbop")
@Data
public class SbopProperties {
    private String name;
    private String version;
    private boolean openAopLog;
    private CaptchaProperties captcha = new CaptchaProperties();
    private QiniuProperties qiniu = new QiniuProperties();
    private static DftProperties dft = new DftProperties();
    private Long tokenTimeout;
    private Long jwtTimeout;
    private String password;
    private Integer nextTermDays;
    private NeteaseProperties netease;
    private String fileTypeRange;
    private String taskPerfix;
    private NationalPartyProperties nationalParty = new NationalPartyProperties();

    public static DftProperties getDft() {
        return dft;
    }

    public void setDft(DftProperties dft) {
        SbopProperties.dft = dft;
    }
}
