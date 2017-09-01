package com.atguigu.mall.sale.service;

import java.util.List;

import com.atguigu.mall.sale.beans.ObjectMallAttr;

public interface AttrService {
	/**
	 * 根据二级分类id查询属性及属性值
	 * @param class_2_id
	 * @return
	 */
	public List<ObjectMallAttr> queryAttrByClass_2_id(int class_2_id);
	
}
