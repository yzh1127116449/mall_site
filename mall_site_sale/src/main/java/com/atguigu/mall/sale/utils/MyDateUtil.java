package com.atguigu.mall.sale.utils;


import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDateUtil {
	
	public static String getPasswordDate(){
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmm");
		String format = sf.format(new Date());
		
		return format;
	}
	
}
