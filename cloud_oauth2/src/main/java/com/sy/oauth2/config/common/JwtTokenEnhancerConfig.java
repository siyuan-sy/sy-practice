package com.sy.oauth2.config.common;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenEnhancerConfig implements TokenEnhancer {


    /**
     * 生成的access_token中添加自己想要的信息
     * @param oAuth2AccessToken
     * @param oAuth2Authentication
     * @return
     */
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        //获取登录的用户信息
        User user = (User)oAuth2Authentication.getUserAuthentication().getPrincipal();

        Map<String, Object> map = new HashMap<>();
        map.put(SecurityConstants.DETAILS_USERNAME, oAuth2Authentication.getName());
        map.put("wangermazi", "思源");
        ((DefaultOAuth2AccessToken)oAuth2AccessToken).setAdditionalInformation(map);
        return oAuth2AccessToken;
    }
}
