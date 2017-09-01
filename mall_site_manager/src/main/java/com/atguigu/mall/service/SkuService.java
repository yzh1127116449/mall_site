package com.atguigu.mall.service;

import java.util.List;

import com.atguigu.mall.beans.MallProduct;
import com.atguigu.mall.beans.MallSku;
import com.atguigu.mall.beans.ModelMallSkuAttrValue;
import com.atguigu.mall.beans.ObjectMallProduct;

public interface SkuService {
	/**
	 * 查询sku信息
	 * @param map
	 * @return
	 */
	public List<MallProduct> querySku(int class_1_id,int class_2_id,int pp_id);

	/**
	 * 保存skui信息
	 * 保存sku_attr_val信息
	 * @param map
	 * @return
	 */
	public boolean save_sku_attr_val(ObjectMallProduct mallProductObj ,ModelMallSkuAttrValue listSku,MallSku sku);
}
