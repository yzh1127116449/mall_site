package com.atguigu.mall.sale.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.mall.sale.beans.MallShoppingCar;
import com.atguigu.mall.sale.beans.MallUserAccount;
import com.atguigu.mall.sale.service.CartService;
import com.atguigu.mall.sale.service.UserService;
import com.atguigu.mall.sale.utils.JsonConvertUtils;
import com.atguigu.mall.sale.utils.MyFactoryBean;
import com.atguigu.mall.sale.utils.MyWsFactory;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	@Autowired
	CartService cartService;
//	@Autowired
//	MyFactoryBean myFactoryBean;
	/**
	 * 注销登录
	 * @return
	 */
	@RequestMapping("/logout")
	public String userLogout(HttpSession session){
		
		session.invalidate();
		return "redirect:/saleIndex.do";
	}
	@RequestMapping("/register")
	public String register(HttpSession session){
		
		return "sale/register";
	}
	
	@RequestMapping("/login")
	public String login(String userType,@CookieValue(value="list_cart_cookie",required=false) String list_cart_cookie,
			MallUserAccount user,HttpSession session,HttpServletResponse response) throws Exception{
		
		//UserService userServiceInf = MyWsFactory.getMyWsImpl("http://localhost:8082/mall_site_user_service/user?wsdl", UserService.class);
		//MallUserAccount loginUser = userServiceInf.doLogin(user);
		MallUserAccount loginUser=null;
		if(userType!=null&&userType.equals("user")){
			loginUser = userService.doLogin(user);
		}else {
			loginUser = userService.doLoginTest(user);
		}
		if(loginUser!=null){
			session.setAttribute("loginUser",loginUser);
			String encode="";
			try {
				encode = URLEncoder.encode(loginUser.getYhMch(), "UTF-8");//cookie中不能有中文
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			Cookie cookie = new Cookie("loginUser",encode);
			cookie.setMaxAge(60*60*24);
			response.addCookie(cookie);
			//同步该用户的购物车信息
			mergeCart(loginUser,session, response,list_cart_cookie);
			
			return "redirect:/saleIndex.do";
		}else{
			return "redirect:/userLogin.htm";
		}
		
	}
	/**
	 * 合并cookie和db中的购物车信息
	 * @param loginUser
	 * @param session
	 * @param response
	 * @param list_cart_cookie
	 */
	private void mergeCart(MallUserAccount loginUser,HttpSession session,HttpServletResponse response,String list_cart_cookie){

		List<MallShoppingCar> list_cart_db = cartService.queryCartByUserId(loginUser.getId());
		
		if(list_cart_db==null){
			//判断cookie中的购物车信息，不为空时同步到数据库中
			if(StringUtils.isNotBlank(list_cart_cookie)){
				List<MallShoppingCar> listCartCookie = JsonConvertUtils.json_to_list(list_cart_cookie, MallShoppingCar.class);
				for (int i = 0; i < listCartCookie.size(); i++) {
					listCartCookie.get(i).setYhId(loginUser.getId());
					cartService.saveCartInfo(listCartCookie.get(i));
				}
			}
		}else{
			if(StringUtils.isNotBlank(list_cart_cookie)){
				List<MallShoppingCar> listCartCookie = JsonConvertUtils.json_to_list(list_cart_cookie, MallShoppingCar.class);
				for (int i = 0; i < listCartCookie.size(); i++) {
					boolean flag = if_new_cookie(list_cart_db,listCartCookie.get(i));
					if(flag){
						//不包含当前的cart对象，直接添加到db
						listCartCookie.get(i).setYhId(loginUser.getId());
						cartService.saveCartInfo(listCartCookie.get(i));
					}else{
						//包含当前的cart对象，更新对应的cart
						for (int j = 0; j < list_cart_db.size(); j++) {
							if(list_cart_db.get(i).getSkuId()==listCartCookie.get(i).getSkuId()){
								MallShoppingCar cart = list_cart_db.get(i);
								Long hj = list_cart_db.get(i).getHj();
								Integer tjshl = list_cart_db.get(i).getTjshl();
								
								cart.setHj(hj+Integer.parseInt(listCartCookie.get(i).getSkuJg())*listCartCookie.get(i).getTjshl());
								cart.setTjshl(tjshl+listCartCookie.get(i).getTjshl());
								
								cartService.saveCartInfo(listCartCookie.get(i));
							}
							
						}
					}
				}
			}
		}
		session.setAttribute("list_cart_session", cartService.queryCartByUserId(loginUser.getId()));
		Cookie cookie = new Cookie("list_cart_cookie","");
		cookie.setMaxAge(60*60);
		response.addCookie(cookie);
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
