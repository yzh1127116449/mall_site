package com.atguigu.mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.atguigu.mall.beans.MallProduct;

public interface SpuMapper {
	
	/**
	 * 保存spu信息
	 * @param mallProduct
	 * @return
	 */
	int saveSpuInfo(MallProduct mallProduct);
	/**
	 * 保存spu图片信息
	 * @param listImage
	 * @return
	 */
	int saveSpuImage(@Param("shp_id")Integer shp_id, @Param("listImage")List<String> listImage);
}
