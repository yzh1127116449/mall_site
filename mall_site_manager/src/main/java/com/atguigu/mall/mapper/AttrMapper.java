package com.atguigu.mall.mapper;

import java.util.List;
import java.util.Map;

import com.atguigu.mall.beans.ObjectMallAttr;

public interface AttrMapper {
	/**
	 * 根据二级分类id查询属性及属性值
	 * @param class_2_id
	 * @return
	 */
	public List<ObjectMallAttr> queryAttrByClass_2_id(int class_2_id);
	/**
	 * 根据二级分类id保存新增属性值
	 * @param mapAttr
	 * @return
	 */
	int addAttr(Map<String,Object> mapAttr);
	
}
