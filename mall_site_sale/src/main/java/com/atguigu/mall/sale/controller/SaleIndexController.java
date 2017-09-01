package com.atguigu.mall.sale.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SaleIndexController {
	
	/**
	 * 登录页面
	 * @return
	 */
	@RequestMapping("/userLogin")
	public String saleLogin(){
		
		return "/sale/sale_login";
	}
	
	/**首页
	 * @return
	 */
	@RequestMapping("/saleIndex")
	public String saleIndex(){
		
		return "/sale/sale_index";
	}
	
	
}
