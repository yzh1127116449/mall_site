package com.atguigu.mall.sale.service;

import com.atguigu.mall.sale.beans.MallAddress;

public interface AddressService {
	/**
	 * 根据用户提交的地址id查询用户的收货地址
	 * @param userId
	 * @return
	 */
	MallAddress queryAddressById(int address_id);
}
