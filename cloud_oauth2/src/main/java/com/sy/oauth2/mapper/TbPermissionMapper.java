package com.sy.oauth2.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sy.oauth2.domain.TbPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbPermissionMapper extends BaseMapper<TbPermission> {
    List<TbPermission> selectByUserId(@Param("userId") Long userId);
}