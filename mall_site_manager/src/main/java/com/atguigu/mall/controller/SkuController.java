package com.atguigu.mall.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.mall.beans.MallProduct;
import com.atguigu.mall.beans.MallSku;
import com.atguigu.mall.beans.ModelMallSkuAttrValue;
import com.atguigu.mall.beans.ObjectMallAttr;
import com.atguigu.mall.beans.ObjectMallProduct;
import com.atguigu.mall.service.AttrService;
import com.atguigu.mall.service.SkuService;

@Controller
public class SkuController {
	
	@Autowired
	SkuService skuService;
	@Autowired 
	AttrService attrService;
	
	/**
	 * 处理异步请求，查询sku
	 * @param class_1_id
	 * @param class_2_id
	 * @param pp_id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/querySkuByPP_id")
	public List<MallProduct> querySkuByPP_id(int class_1_id,int class_2_id,int pp_id){
		
		List<MallProduct> listSku = skuService.querySku(class_1_id, class_2_id, pp_id);
		
		return listSku;
	}
	
	@RequestMapping("/save_sku_attr")
	public ModelAndView save_sku_attr(ObjectMallProduct mallProductObj ,ModelMallSkuAttrValue listSku,MallSku sku){
		
		ModelAndView mv = new ModelAndView ("redirect:/manager_index.htm");
		mv.addObject("url", "to_manager_sku.htm");
		mv.addObject("title", "库存信息");
		skuService.save_sku_attr_val(mallProductObj, listSku, sku);
		
		return mv;
	}
	
	/**
	 * 处理异步请求，返回内嵌页面
	 * @param class_2_id
	 * @param class_2_name
	 * @param map
	 * @return
	 */
	@RequestMapping("/query_attr_inner")
	public String query_attr_inner(int class_2_id,Map<String,Object> map){
		
		List<ObjectMallAttr> queryAttrByClass_2_id = attrService.queryAttrByClass_2_id(class_2_id);
 		map.put("attr_value_class_2", queryAttrByClass_2_id);
		map.put("class_2_id", class_2_id);
		
		return "/backstage_manager/manager_sku_attr_inner";
	}
}
