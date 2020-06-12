package com.sy.oauth2.config.common;



import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

//继承默认的token转换器,重写access_token解析逻辑
public class CustomAccessTokenConverter extends DefaultAccessTokenConverter {
    /**
     * 从请求上下文中获取当前请求
     * @return
     */
    public static HttpServletRequest getCurrentRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        return request;
    }

    /**
     * 将jwt中payload放入OAuth2Authentication
     * @param claims
     * @return
     */
    @Override
    public OAuth2Authentication extractAuthentication(Map<String, ?> claims) {
        OAuth2Authentication authentication = super.extractAuthentication(claims);
        HttpServletRequest currentRequest = this.getCurrentRequest();
       /* currentRequest.setAttribute(Constants.USERID, claims.get(Constants.USERID));
        currentRequest.setAttribute(Constants.RY_JB_WID, claims.get(Constants.RY_JB_WID));
        currentRequest.setAttribute(Constants.TENANT_WID, claims.get(Constants.TENANT_WID));
        currentRequest.setAttribute(Constants.USER_TYPE, claims.get(Constants.USER_TYPE));*/
        return authentication;
    }

}
