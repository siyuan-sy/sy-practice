package com.sy.oauth2.service;


import com.sy.oauth2.domain.TbUser;

public interface TbUserService {
    default TbUser getByUsername(String username) {
        return null;
    }
}
