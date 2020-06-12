package com.sy.common;

import lombok.Data;

/**
 * @ClassName QiniuProperties
 * @Description 七牛云配置参数
 * @Author DINGLAN
 * @Date 2019/3/26 16:05
 **/
@Data
public class QiniuProperties {

    private String accessKey;
    private String secretKey;
    private String bucket;
    private String path;
}
