package com.atguigu.mall.sale.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.mall.sale.beans.MallAddress;
import com.atguigu.mall.sale.beans.MallUserAccount;
import com.atguigu.mall.sale.beans.ObjectMallFlow;
import com.atguigu.mall.sale.beans.ObjectMallOrder;
import com.atguigu.mall.sale.mapper.OrderMapper;
import com.atguigu.mall.sale.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	OrderMapper orderMapper;

	@Override
	public void saveOrderInfo(MallUserAccount user, ObjectMallOrder order, MallAddress address) {
		
		order.setDzhId(address.getId());
		order.setShhr(address.getShjr());
		order.setDzhMch(address.getDzMch());
		orderMapper.saveOrder(order);
		
		List<ObjectMallFlow> listOrder = order.getListOrder();
		for (int i = 0; i < listOrder.size(); i++) {
			listOrder.get(i).setDdId(order.getId());
			listOrder.get(i).setMdd(address.getDzMch());
			listOrder.get(i).setYhId(user.getId());
			//orderMapper.saveFlow(listOrder.get(i));
		}
	}

}
