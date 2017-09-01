package com.atguigu.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManagerController {
	
	@RequestMapping("/manager_index")
	public String toIndex(String url,String title,ModelMap map){
		
		map.put("url", url);
		map.put("title", title);
		
		return "backstage_manager/manager_index";
	}
	/**
	 * 去往spu页面
	 * @return
	 */
	@RequestMapping("/to_manager_spu")
	public String saleSpu(){
		
		return "backstage_manager/manager_spu";
	}
	@RequestMapping("/to_manager_sku")
	public String saleSku(){
		
		return "backstage_manager/manager_sku";
	}
}
