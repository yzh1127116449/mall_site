package com.atguigu.mall.sale.beans;

import java.util.List;

public class ObjectMallOrder extends MallOrder {
	 
	private List<ObjectMallFlow> listOrder;

	public List<ObjectMallFlow> getListOrder() {
		return listOrder;
	}

	public void setListOrder(List<ObjectMallFlow> listOrder) {
		this.listOrder = listOrder;
	}
	
	
}
