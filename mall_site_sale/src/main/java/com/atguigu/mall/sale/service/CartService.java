package com.atguigu.mall.sale.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.atguigu.mall.sale.beans.MallShoppingCar;

public interface CartService {
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
	 * @param skuId
	 * @return
	 */
	int updateCartInfo(@Param("userId")int userId,@Param("cart")MallShoppingCar cart);
	/**
	 * 根据用户id查询购物车信息
	 * @param userId
	 * @return
	 */
	List<MallShoppingCar> queryCartByUserId(Integer userId);

}
