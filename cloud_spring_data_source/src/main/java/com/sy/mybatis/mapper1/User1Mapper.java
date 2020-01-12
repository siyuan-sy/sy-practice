package com.sy.mybatis.mapper1;


import com.sy.mybatis.entity.XbUsers;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface User1Mapper {
//    @Select("select name,age from user")
    List<XbUsers> selectByMobile(@Param("mobile") String mobile);
}