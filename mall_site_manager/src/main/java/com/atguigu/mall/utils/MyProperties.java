package com.atguigu.mall.utils;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class MyProperties {
	
	public static String  getUploadPath(String key){
		
//		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
//		String formatDate = sf.format(new Date());
		
		Properties properties = new Properties();
		
		InputStream inputStream = MyProperties.class.getClassLoader().getResourceAsStream("path.properties");
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String path = properties.getProperty(key);
		
		return path;
	}
}
