package com.siyuan.oauth2.service;


import com.siyuan.oauth2.domain.TbUser;

public interface TbUserService {
    default TbUser getByUsername(String username) {
        return null;
    }
}
