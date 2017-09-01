package com.atguigu.mall.sale.beans;

import java.util.List;

public class ObjectMallAttr extends MallAttr {
	
	private List<MallValue> list_value;

	public List<MallValue> getList_value() {
		return list_value;
	}

	public void setList_value(List<MallValue> list_value) {
		this.list_value = list_value;
	}

	@Override
	public String toString() {
		return "ObjectMallAttr [list_value=" + list_value + "]";
	}

	
}
