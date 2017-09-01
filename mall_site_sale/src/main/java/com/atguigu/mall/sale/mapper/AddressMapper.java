package com.atguigu.mall.sale.mapper;

import com.atguigu.mall.sale.beans.MallAddress;

public interface AddressMapper {
	
	/**
	 * com.atguigu.mall.sale.beans.MallAddress
	 * @param userId
	 * @return
	 */
	MallAddress queryAddressById(int address_id);
}
