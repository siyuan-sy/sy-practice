package com.sy.mybatis.mapper2;
import com.sy.mybatis.entity.XbUsers;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
public interface User2Mapper {
   // @Select("select name,age from user")
    List<XbUsers> selectByMobile(@Param("mobile") String mobile);

}