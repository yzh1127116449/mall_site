package com.atguigu.mall.sale.service;

import com.atguigu.mall.sale.beans.MallAddress;
import com.atguigu.mall.sale.beans.MallUserAccount;
import com.atguigu.mall.sale.beans.ObjectMallOrder;

public interface OrderService {

	/**
	 * 保存定单信息
	 * @param user
	 * @param order
	 * @param dzMch
	 */
	void saveOrderInfo(MallUserAccount user, ObjectMallOrder order, MallAddress address);
	
}
