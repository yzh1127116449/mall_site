package com.atguigu.mall.sale.service;

import java.util.List;

import com.atguigu.mall.sale.beans.DetailMallSku;
import com.atguigu.mall.sale.beans.MallSkuAttrValue;
import com.atguigu.mall.sale.beans.ObjectMallSku;

public interface SearchService {
	/**
	 * 查询商品信息
	 * @param class_2_id
	 * @return
	 */
	List<ObjectMallSku> queryProductInfoByClass_2_id(int class_2_id);
	/**
	 * 查询某个商品详细信息
	 * @param class_2_id
	 * @param spuId
	 * @return
	 */
	List<ObjectMallSku> queryProductDetails(int spuId);
	/**
	 * 根据筛选条件，查询商品信息
	 * @param classs_2_id
	 * @param listSku
	 * @return
	 */
	List<ObjectMallSku> queryProductByCondition(String order,int classs_2_id,List<MallSkuAttrValue> listSku);
	/**
	 * 根据skuId查询商品详细信息
	 * @param skuId
	 * @return
	 */
	DetailMallSku querySkuDetailsBySkuId(int skuId);
}
