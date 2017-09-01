package com.atguigu.mall.mapper;

import java.util.List;
import java.util.Map;

import com.atguigu.mall.beans.MallProduct;

public interface SkuMapper {
	/**
	 * 查询sku信息
	 * @param map
	 * @return
	 */
	public List<MallProduct> querySku(Map<String,Object> map);
	/**
	 * 保存sku库存信息
	 * @param mallSku
	 * @return
	 */
	public int save_sku_attr(Map<String,Object> map);
	/**
	 * 
	 * 保存sku_attr_val信息
	 * @param map
	 * @return
	 */
	public int save_sku_attr_val(Map<String,Object> map);
	
}
