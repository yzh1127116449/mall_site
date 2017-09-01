package com.atguigu.mall.sale.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.mall.sale.beans.DetailMallSku;
import com.atguigu.mall.sale.beans.ModelMallSkuAttrValue;
import com.atguigu.mall.sale.beans.ObjectMallAttr;
import com.atguigu.mall.sale.beans.ObjectMallSku;
import com.atguigu.mall.sale.service.AttrService;
import com.atguigu.mall.sale.service.SearchService;

@Controller
public class SearchController {
	
	@Autowired
	SearchService searchService;
	@Autowired
	private AttrService attrService;
	/**
	 * 根据二级分类的id查询商品信息
	 * @param class_2_id
	 * @param map
	 * @return
	 */
	@RequestMapping("search_product")
	public String searchProduct(int class_2_id,ModelMap map){
		
		List<ObjectMallAttr> attrList = attrService.queryAttrByClass_2_id(class_2_id);
		List<ObjectMallSku> listProductInfo = searchService.queryProductInfoByClass_2_id(class_2_id);
		map.put("listProductInfo", listProductInfo);
		map.put("attrList", attrList);
		map.put("class_2_id",class_2_id);
		return "/sale/sale_search";
	}
	/**
	 * 根据不同的检索条件查询商品
	 * @param order
	 * @param class_2_id
	 * @param sku_attr_val
	 * @param map
	 * @return
	 */
	@RequestMapping("queryProductByCondition")
	public String searchProductByCondition(String order,int class_2_id,ModelMallSkuAttrValue sku_attr_val,ModelMap map){
		
		List<ObjectMallSku> sku = searchService.queryProductInfoByClass_2_id(class_2_id);
		List<ObjectMallSku> list_sku = searchService.queryProductByCondition(order,class_2_id, sku_attr_val.getListSku());
		map.put("listProductInfo", list_sku);
		map.put("attrList", sku);
		map.put("class_2_id",class_2_id);
		return "/sale/sale_search_inner";
	}
	/**
	 * 查询商品详细信息
	 * @param class_2_id
	 * @param spuId
	 * @param map
	 * @return
	 */
	@RequestMapping("search_details")
	public String searchDetails(int skuId,int spuId,ModelMap map){
		List<ObjectMallSku> objectMallSku = searchService.queryProductDetails(spuId);
		DetailMallSku skuDetails = searchService.querySkuDetailsBySkuId(skuId);
		map.put("productDetails", objectMallSku);
		map.put("skuDetails", skuDetails);
		return "/sale/sale_search_details";
	}
}
