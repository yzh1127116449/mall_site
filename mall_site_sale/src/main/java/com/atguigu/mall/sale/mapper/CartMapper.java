package com.atguigu.mall.sale.mapper;

import java.util.List;
import java.util.Map;

import com.atguigu.mall.sale.beans.MallShoppingCar;

public interface CartMapper {
	/**
	 * 保存购物车信息
	 * @param cart
	 * @return
	 */
	int saveCartInfo(MallShoppingCar cart);
	/**
	 * 查询购物车中的商品
	 * @return
	 */
	List<MallShoppingCar> queryProductFromCart();
	/**
	 * 更新购物车数据
	 * @param map
	 * @return
	 */
	int updateCartInfo(Map<String,Object> map);
	/**
	 * 根据用户id查询购物车信息
	 * @param userId
	 * @return
	 */
	List<MallShoppingCar> queryCartByUserId(Integer userId);
}
