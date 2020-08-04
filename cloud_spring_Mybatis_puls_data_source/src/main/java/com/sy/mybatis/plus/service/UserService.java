package com.sy.mybatis.plus.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.sy.mybatis.plus.entity.User;
import com.sy.mybatis.plus.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author siyuan
 * @create 2020/7/30
 */
@Service
public class UserService {
	@Autowired
	UserMapper xbUserMapper;

	public Object getUser(){
//		List<User> xbUsers1 = xbUserMapper.selectByMobile1();
		List<User> users = xbUserMapper.selectList(null);
		System.out.println("xbUsers1 = " + users);
		List<User> xbUsers2= xbUserMapper.selectList(null);
		System.out.println("xbUsers2 = " + xbUsers2);
		return  users +"\n" + xbUsers2;
	}
}
