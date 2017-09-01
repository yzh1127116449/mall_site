package com.atguigu.mall.sale.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.atguigu.mall.sale.beans.DetailMallSku;
import com.atguigu.mall.sale.beans.ObjectMallSku;

public interface SearchMapper {
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
	 * @param map
	 * @return
	 */
	List<ObjectMallSku> queryProductByCondition(Map<String,Object> map);
	/**
	 * 根据skuId查询商品详细信息
	 * @param skuId
	 * @return
	 */
	DetailMallSku querySkuDetailsBySkuId(int skuId);
}
