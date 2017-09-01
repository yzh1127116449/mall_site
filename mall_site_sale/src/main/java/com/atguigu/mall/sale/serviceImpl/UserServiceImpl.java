package com.atguigu.mall.sale.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.atguigu.mall.sale.beans.MallUserAccount;
import com.atguigu.mall.sale.mapper.UserMapper;
import com.atguigu.mall.sale.service.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;
	
	@Override
	public MallUserAccount doLogin(MallUserAccount user) {
		MallUserAccount loginUser = userMapper.doLogin(user);
		return loginUser;
	}

	@Override
	public MallUserAccount doLoginTest(MallUserAccount user) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
