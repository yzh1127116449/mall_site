package com.atguigu.mall.sale.service;

import javax.jws.WebService;

import com.atguigu.mall.sale.beans.MallUserAccount;

@WebService
public interface UserService {
	/**
	 * 用户登录系统业务
	 * @param user
	 * @return
	 */
	MallUserAccount doLogin(MallUserAccount user);
	/**
	 * 连接测试库
	 * @param user
	 * @return
	 */
	MallUserAccount doLoginTest(MallUserAccount user);
}
