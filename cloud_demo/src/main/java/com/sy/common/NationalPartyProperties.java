package com.sy.common;

import lombok.Data;

/**
 * @Description TODO
 * @Author DingLan
 * @Date 2020/5/20 13:43
 **/
@Data
public class NationalPartyProperties {
    private String userName;
    private String userPwd;
    private String perfix;
    private String loginUrl;
    private String memberUrl;
    private Long tokenTimeout;
    private String getDzzListUrl;
    private String loadzzjgTreeUrl;
}
