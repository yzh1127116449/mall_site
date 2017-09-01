package com.atguigu.mall.sale.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.mall.sale.beans.MallShoppingCar;
import com.atguigu.mall.sale.beans.MallUserAccount;
import com.atguigu.mall.sale.service.CartService;
import com.atguigu.mall.sale.utils.JsonConvertUtils;

@Controller
public class CartController {

	@Autowired
	CartService cartService;
	/**
	 * 购物车页面
	 * @param map
	 * @return
	 */
	@RequestMapping("cartIndex")
	public String cartIndex(HttpSession session,ModelMap map) {

		List<MallShoppingCar> list_cart = cartService.queryProductFromCart();
		map.put("listCart", list_cart);
		int totalPrice = 0;
		for (int i = 0; i < list_cart.size(); i++) {
			totalPrice += list_cart.get(i).getHj();
		}
		session.setAttribute("totalPrice", totalPrice);
		session.setAttribute("list_cart", list_cart);
		
		return "sale/sale_cart";
	}
	/**
	 * 异步请求迷你购物车
	 * @param list_cart_cookie
	 * @param map
	 * @return
	 */
	@RequestMapping("getMiniCart")
	public String getMiniCart(@CookieValue(value="list_cart_cookie",required=false)String list_cart_cookie,ModelMap map) {
		int totalCount = 0;
		long totalPrice = 0;
		List<MallShoppingCar> list_cart = cartService.queryProductFromCart();
		//将cookie中的购物车信息与db中合并
		if(StringUtils.isNotBlank(list_cart_cookie)){
			List<MallShoppingCar> listCartInCookie = JsonConvertUtils.json_to_list(list_cart_cookie, MallShoppingCar.class);
			for (int i = 0; i < listCartInCookie.size(); i++) {
				list_cart.add(listCartInCookie.get(i));
			}
		}
		for (int i = 0; i < list_cart.size(); i++) {
			totalCount += list_cart.get(i).getTjshl();
			totalPrice += list_cart.get(i).getHj();
		}
		map.put("listCart", list_cart);
		map.put("totalCount", totalCount);
		map.put("totalPrice", totalPrice);
		
		return "sale/sale_mini_cart_inner";
	}
	/**
	 * 添加商品到购物车
	 * 
	 * @param cart
	 * @param list_cart_cookie_param
	 * @param session
	 * @param response
	 * @param map
	 * @return
	 */
	@RequestMapping("addProductToCart.do")
	public String addToCart(MallShoppingCar cart,
			@CookieValue(value = "list_cart_cookie", required = false) String list_cart_cookie_param,
			HttpSession session, HttpServletResponse response, ModelMap map) {

		MallUserAccount loginUser = (MallUserAccount) session.getAttribute("loginUser");
		
		List<MallShoppingCar> listCart = new ArrayList<MallShoppingCar>();
		if (loginUser != null) {
			// 用户已经登录
			cart.setYhId(loginUser.getId());
			listCart = (List<MallShoppingCar>) session.getAttribute("list_cart_session");
			if (listCart == null || listCart.size() == 0) {
				List<MallShoppingCar> listCartSession = new ArrayList<MallShoppingCar>();
				session.setAttribute("list_cart_session", listCartSession.add(cart));
				
				int count = cartService.saveCartInfo(cart);
			} else {
				boolean flag = if_new_cookie(listCart, cart);
				if (flag) {
					// session中购物车集合不包含当前添加的商品--直接更新session中的购物车集合同时添加到数据库
					listCart.add(cart);
					cartService.saveCartInfo(cart);
				} else {
					// session中的购物车集合包含当前添加的商品
					for (int i = 0; i < listCart.size(); i++) {
						if (listCart.get(i).getSkuId() == cart.getSkuId()) {
							MallShoppingCar shoppingCart = listCart.get(i);
							Integer tjshl = shoppingCart.getTjshl();
							Long hj = shoppingCart.getHj();

							shoppingCart.setHj(hj + Integer.parseInt(cart.getSkuJg()) * cart.getTjshl());
							shoppingCart.setTjshl(tjshl + cart.getTjshl());
							//更新db中购物车的数据
							cartService.updateCartInfo(loginUser.getId(),listCart.get(i));
							break;
						}
					}
				}
			}
		} else {
			// 用户未登录
			if (StringUtils.isBlank(list_cart_cookie_param)) {
				// cookie中无数据
				listCart.add(cart);

			} else {
				// cookie中有数据
				listCart = JsonConvertUtils.json_to_list(list_cart_cookie_param, MallShoppingCar.class);
				boolean result = if_new_cookie(listCart, cart);
				if (result) {
					// 老数据---更新数量及合计
					for (int i = 0; i < listCart.size(); i++) {
						if (listCart.get(i).getSkuId() == cart.getSkuId()) {
							MallShoppingCar shoppingCart = listCart.get(i);
							Integer tjshl = shoppingCart.getTjshl();
							Long hj = shoppingCart.getHj();

							shoppingCart.setHj(hj + Integer.parseInt(cart.getSkuJg()) * cart.getTjshl());
							shoppingCart.setTjshl(tjshl + cart.getTjshl());
							break;
						}
					}
				} else {
					// 新数据 直接添加
					listCart.add(cart);
				}
			}
			Cookie cookie = new Cookie("list_cart_cookie", JsonConvertUtils.list_to_json(listCart));
			cookie.setMaxAge(60 * 60 * 24);
			response.addCookie(cookie);
		}

		return "redirect:/cartIndex.do";
	}

	/**
	 * 判断集合中的有没有当前的cart
	 * 
	 * @param listCart
	 * @param cart
	 * @return 集合中包含当前的cart对象，返回false
	 */
	private boolean if_new_cookie(List<MallShoppingCar> listCart, MallShoppingCar cart) {
		boolean flag = true;
		for (int i = 0; i < listCart.size(); i++) {
			if (listCart.get(i).getSkuId() == cart.getSkuId()) {
				flag = false;
				break;
			}
		}
		return flag;
	}
}
