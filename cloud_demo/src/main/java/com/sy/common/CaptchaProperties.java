package com.sy.common;

import lombok.Data;

/**
 * @ClassName CaptchaProperties
 * @Description 验证码图片属性类
 * @Author DINGLAN
 * @Date 2019/2/27 13:40
 **/
@Data
public class CaptchaProperties {
    // 验证码图片宽度
    private int width = 146;
    // 验证码图片高度
    private int height = 33;
    // 验证码字符位数
    private int length = 4;
}
