package com.atguigu.mall.sale.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.atguigu.mall.sale.beans.MallAddress;
import com.atguigu.mall.sale.beans.MallOrderInfo;
import com.atguigu.mall.sale.beans.MallShoppingCar;
import com.atguigu.mall.sale.beans.MallUserAccount;
import com.atguigu.mall.sale.beans.ObjectMallFlow;
import com.atguigu.mall.sale.beans.ObjectMallOrder;
import com.atguigu.mall.sale.service.AddressService;
import com.atguigu.mall.sale.service.OrderService;

@Controller
@SessionAttributes("order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	@Autowired
	AddressService addressService;
	/**
	 * 保存订单信息
	 * @return
	 */
	@RequestMapping("saveOrder")
	public String saveOrder(@RequestParam("address_id")int address_id,@ModelAttribute("order") ObjectMallOrder order, HttpSession session){
		MallUserAccount user = (MallUserAccount) session.getAttribute("loginUser");
		
		MallAddress userAddress = addressService.queryAddressById(address_id);
		orderService.saveOrderInfo(user,order,userAddress);
		
		return "redirect:/pay.do";
	}
	@RequestMapping("pay")
	public String verify_pay(){
		
		return "sale/sale_pay";
	}
	/**
	 * 用户订单确认页面,拆单、分包裹
	 * @param session
	 * @return
	 */
	@RequestMapping("/payIndex")
	public String payIndex(HttpSession session,ModelMap map){
		MallUserAccount user = (MallUserAccount) session.getAttribute("loginUser");
		List<MallShoppingCar> listCart = (List<MallShoppingCar>) session.getAttribute("list_cart");
		//存放库存地址
		Set<String> listAddress = new HashSet<String>();
		//总金额
		BigDecimal zje = new BigDecimal("0");
		for (int i = 0; i < listCart.size(); i++) {
			listAddress.add(listCart.get(i).getKcdz());
		}
		//订单信息（包含多个包裹--listFlow，每个包裹里有多个商品，每个包裹对应一个物流信息）
		ObjectMallOrder order = new ObjectMallOrder();
		List<ObjectMallFlow> listFlow = new ArrayList<ObjectMallFlow>();
		Iterator<String> iterator = listAddress.iterator();
		while(iterator.hasNext()){
			//根据库存地址分包裹
			String address = iterator.next();
			ObjectMallFlow flow = new ObjectMallFlow();
			flow.setCkdz(address);
			List<MallOrderInfo> listOrderInfo  = new ArrayList<MallOrderInfo>();
			for (int i = 0; i < listCart.size(); i++) {
				if(listCart.get(i).getKcdz().equals(address) && listCart.get(i).getShfxz().equals("1")){
					//累加总金额
					zje=zje.add(new BigDecimal(listCart.get(i).getHj()+""));
					
					MallOrderInfo orderInfo = new MallOrderInfo();
					orderInfo.setGwchId(listCart.get(i).getId());
					orderInfo.setSkuId(listCart.get(i).getSkuId());
					orderInfo.setShpTp(listCart.get(i).getShpTp());
					orderInfo.setSkuJg((long)Integer.parseInt(listCart.get(i).getSkuJg()));
					orderInfo.setSkuMch(listCart.get(i).getSkuMch());
					orderInfo.setSkuShl(listCart.get(i).getTjshl());
					orderInfo.setSkuKcdz(listCart.get(i).getKcdz());
					listOrderInfo.add(orderInfo);
				}
			}
			flow.setPsfsh("硅谷速递");
			flow.setYhId(user.getId());
			flow.setMqdd("商品未出库");
			flow.setListOrderInfo(listOrderInfo);
			listFlow.add(flow);
			
		}
		order.setListOrder(listFlow);
		order.setJdh(1);
		order.setZje(zje);
		order.setYhId(user.getId());
		
		map.put("order", order);
		map.put("listAddress", listAddress);
		return "sale/sale_pay_index";
	}
	
}
