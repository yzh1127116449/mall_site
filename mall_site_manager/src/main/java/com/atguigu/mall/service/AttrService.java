package com.atguigu.mall.service;

import java.util.List;

import com.atguigu.mall.beans.ObjectMallAttr;

public interface AttrService {
	/**
	 * 根据二级分类id查询属性及属性值
	 * @param class_2_id
	 * @return
	 */
	public List<ObjectMallAttr> queryAttrByClass_2_id(int class_2_id);
	/**
	 * 保存属性及属性值
	 * @param list_attr
	 * @return
	 */
	boolean addAttr(int class_2_id,List<ObjectMallAttr> list_attr);
	
}
