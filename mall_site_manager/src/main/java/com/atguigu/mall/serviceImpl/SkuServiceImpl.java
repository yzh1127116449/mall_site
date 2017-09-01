package com.atguigu.mall.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.mall.beans.MallProduct;
import com.atguigu.mall.beans.MallSku;
import com.atguigu.mall.beans.ModelMallSkuAttrValue;
import com.atguigu.mall.beans.ObjectMallProduct;
import com.atguigu.mall.mapper.SkuMapper;
import com.atguigu.mall.service.SkuService;

@Service
public class SkuServiceImpl implements SkuService {

	@Autowired
	SkuMapper skuMapper;
	
	@Override
	public List<MallProduct> querySku(int class_1_id,int class_2_id,int pp_id) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("class_1_id", class_1_id);
		map.put("class_2_id", class_2_id);
		map.put("pp_id", pp_id);
		
		List<MallProduct> listSku = skuMapper.querySku(map);
		
		return listSku;
		
	}

	@Override
	public boolean save_sku_attr_val(ObjectMallProduct spu ,ModelMallSkuAttrValue listSku,MallSku sku) {
		
		Map<String,Object> map1 = new HashMap<String,Object>();
		map1.put("spu", spu);
		map1.put("sku", sku);
		int saveCount = skuMapper.save_sku_attr(map1);
		
		Map<String,Object> map2 = new HashMap<String,Object>();
		
		map2.put("list_attr_val", listSku.getListSku());
		map2.put("spu_id", spu.getSpuId());
		map2.put("sku_id", sku.getId());
		int saveCount2 = skuMapper.save_sku_attr_val(map2);
		
		if(saveCount>0&&saveCount2>0){
			return true;
			
		}else{
			
			return false;
		}
	}

}
