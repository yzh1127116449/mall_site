package com.atguigu.mall.sale.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import com.atguigu.mall.sale.beans.MallShoppingCar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import net.sf.json.JSONArray;

public class JsonConvertUtils {

	public static void main(String[] args) throws UnsupportedEncodingException {
		List<MallShoppingCar> list_car = new ArrayList<MallShoppingCar>();

		for (int i = 0; i < 3; i++) {
			MallShoppingCar shoppingCart = new MallShoppingCar();
			shoppingCart.setSkuMch("商品" + i);
			shoppingCart.setSkuJg(i * 1000+"");
			list_car.add(shoppingCart);
		}

		// 1
		Gson gson = new Gson();
		String json = gson.toJson(list_car);
		json = URLEncoder.encode(json, "utf-8");
		String decode = URLDecoder.decode(json, "utf-8");
		TypeToken<List<MallShoppingCar>> typeToken = new TypeToken<List<MallShoppingCar>>() {
		};
		List<MallShoppingCar> list = (List<MallShoppingCar>) gson.fromJson(decode, typeToken.getType());

		List<MallShoppingCar> json_to_list = json_to_list(json, MallShoppingCar.class);

		// 2
		JSONArray fromObject = JSONArray.fromObject(list_car);
		String string = fromObject.toString();
		System.err.println(string);
		JSONArray fromObject2 = JSONArray.fromObject(string);
		List<MallShoppingCar> list_array = (List<MallShoppingCar>) JSONArray.toCollection(fromObject2,
				MallShoppingCar.class);
		System.out.println(list_array);

	}

	public static <T> List<T> json_to_list(String json, Class<T> t) {
		String decode = "";
		try {
			decode = URLDecoder.decode(json, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray fromObject2 = JSONArray.fromObject(decode);

		List<T> list_array = (List<T>) JSONArray.toCollection(fromObject2, t);

		return list_array;
	}

	public static <T> String list_to_json(List<T> list) {

		Gson gson = new Gson();
		String json = gson.toJson(list);

		try {
			json = URLEncoder.encode(json, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return json;

	}

}
