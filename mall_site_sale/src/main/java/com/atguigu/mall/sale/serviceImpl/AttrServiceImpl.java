package com.atguigu.mall.sale.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.mall.sale.beans.ObjectMallAttr;
import com.atguigu.mall.sale.mapper.AttrMapper;
import com.atguigu.mall.sale.service.AttrService;

@Service
public class AttrServiceImpl implements AttrService {

	@Autowired
	private AttrMapper attrMapper;

	@Override
	public List<ObjectMallAttr> queryAttrByClass_2_id(int class_2_id) {

		List<ObjectMallAttr> queryAttrByClass_2_id = attrMapper.queryAttrByClass_2_id(class_2_id);

		return queryAttrByClass_2_id;
	}

}
