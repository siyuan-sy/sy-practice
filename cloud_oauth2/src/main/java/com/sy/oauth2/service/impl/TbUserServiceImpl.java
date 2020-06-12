package com.sy.oauth2.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sy.oauth2.domain.TbUser;
import com.sy.oauth2.mapper.TbUserMapper;
import com.sy.oauth2.service.TbUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TbUserServiceImpl implements TbUserService {

    @Resource
    private TbUserMapper tbUserMapper;

    @Override
    public TbUser getByUsername(String username) {
        return tbUserMapper.selectOne(new QueryWrapper<TbUser>().eq("username",username));
    }
}
