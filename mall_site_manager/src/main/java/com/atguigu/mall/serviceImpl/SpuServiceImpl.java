package com.atguigu.mall.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.mall.beans.MallProduct;
import com.atguigu.mall.mapper.SpuMapper;
import com.atguigu.mall.service.SpuService;

@Service
public class SpuServiceImpl implements SpuService{
	
	@Autowired 
	SpuMapper spuMapper;

	@Override
	public int saveSpuInfo(MallProduct mallProduct) {
		int count = spuMapper.saveSpuInfo(mallProduct);
		return count;
	}

	@Override
	public int saveSpuImage(Integer shp_id ,List<String> list ){
		
		int count = spuMapper.saveSpuImage(shp_id,list);
		
		return count;
	}
	
}
