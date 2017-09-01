package com.atguigu.mall.sale.mapper;

import com.atguigu.mall.sale.beans.MallUserAccount;

public interface UserMapper {
	/**
	 * 用户登录系统
	 * @param user
	 * @return
	 */
	MallUserAccount doLogin(MallUserAccount user);
}
