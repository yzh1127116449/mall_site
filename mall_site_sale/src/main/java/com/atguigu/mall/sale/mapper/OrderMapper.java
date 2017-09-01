package com.atguigu.mall.sale.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.atguigu.mall.sale.beans.ObjectMallFlow;
import com.atguigu.mall.sale.beans.ObjectMallOrder;

public interface OrderMapper {
	/**
	 * 保存订单中的物流信息和Sku信息，多个物流信息对应多个Sku信息
	 * @param order
	 * @return
	 */
	int saveOrder(ObjectMallOrder order);
	/**
	 * 保存订单中每个包裹的物流信息
	 * @param listOrder
	 * @return
	 */
	int saveFlow(ObjectMallFlow flow);

}
