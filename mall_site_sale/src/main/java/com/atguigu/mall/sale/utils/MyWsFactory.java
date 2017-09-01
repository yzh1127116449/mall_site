package com.atguigu.mall.sale.utils;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class MyWsFactory {

	public static <T> T getMyWsImpl(String url,Class<T> t){
		
		JaxWsProxyFactoryBean jaxWsProxyFactoryBean  = new JaxWsProxyFactoryBean();
		jaxWsProxyFactoryBean.setAddress(url);
		jaxWsProxyFactoryBean.setServiceClass(t);
		T create = (T) jaxWsProxyFactoryBean.create();
		return create;
	}
}
