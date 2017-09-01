package com.atguigu.mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.atguigu.mall.beans.ObjectMallAttr;

public interface AttrValueMapper {
	/**
	 * 保存属性值
	 * @param list_attr
	 * @return
	 */
	int addAttrValue(@Param("list_attr")List<ObjectMallAttr> list_attr);
}
