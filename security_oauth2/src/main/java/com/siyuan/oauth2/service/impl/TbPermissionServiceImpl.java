package com.siyuan.oauth2.service.impl;

import com.siyuan.oauth2.domain.TbPermission;
import com.siyuan.oauth2.mapper.TbPermissionMapper;
import com.siyuan.oauth2.service.TbPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TbPermissionServiceImpl implements TbPermissionService {

    @Resource
    private TbPermissionMapper tbPermissionMapper;

    @Override
    public List<TbPermission> selectByUserId(Long userId) {
        return tbPermissionMapper.selectByUserId(userId);
    }
}
