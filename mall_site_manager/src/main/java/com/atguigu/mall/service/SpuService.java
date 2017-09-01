package com.atguigu.mall.service;

import java.util.List;

import com.atguigu.mall.beans.MallProduct;

public interface SpuService {
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
	int saveSpuImage(Integer shp_id ,List<String> list);
}
