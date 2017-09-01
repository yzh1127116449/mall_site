package com.atguigu.mall.sale.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.mall.sale.beans.MallShoppingCar;
import com.atguigu.mall.sale.mapper.CartMapper;
import com.atguigu.mall.sale.service.CartService;
@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartMapper cartMapper;
	
	@Override
	public int saveCartInfo(MallShoppingCar cart) {
		int saveCount = cartMapper.saveCartInfo(cart);
		return saveCount;
	}

	@Override
	public List<MallShoppingCar> queryProductFromCart() {
		
		return cartMapper.queryProductFromCart();
	}

	@Override
	public int updateCartInfo(int userId,MallShoppingCar cart) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", userId);
		map.put("cart", cart);
		return cartMapper.updateCartInfo(map);
	}

	@Override
	public List<MallShoppingCar> queryCartByUserId(Integer userId) {
		
		return cartMapper.queryCartByUserId(userId);
	}

}
