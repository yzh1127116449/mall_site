package com.atguigu.mall.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.mall.beans.ObjectMallAttr;
import com.atguigu.mall.mapper.AttrMapper;
import com.atguigu.mall.mapper.AttrValueMapper;
import com.atguigu.mall.service.AttrService;

@Service
public class AttrServiceImpl implements AttrService {

	@Autowired
	private AttrMapper attrMapper;
	@Autowired
	private AttrValueMapper attrValueMapper;

	@Override
	public List<ObjectMallAttr> queryAttrByClass_2_id(int class_2_id) {

		List<ObjectMallAttr> queryAttrByClass_2_id = attrMapper.queryAttrByClass_2_id(class_2_id);

		return queryAttrByClass_2_id;
	}

	@Override
	public boolean addAttr(int class_2_id, List<ObjectMallAttr> list_attr) {
		boolean result=false;
		int addAttr=0;
		for (int i = 0; i < list_attr.size(); i++) {
			Map<String,Object> mapAttr = new HashMap<String,Object>();
			
			mapAttr.put("class_2_id", class_2_id);
			mapAttr.put("attr_obj", list_attr.get(i));
			addAttr = attrMapper.addAttr(mapAttr);
			
		}
		
		int addAttrValue = attrValueMapper.addAttrValue(list_attr);
		if(addAttr>0&&addAttrValue>0){
			result=true;
		}
		return result;
	}

}
