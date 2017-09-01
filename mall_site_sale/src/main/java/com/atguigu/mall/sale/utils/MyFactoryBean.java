package com.atguigu.mall.sale.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean<T> implements FactoryBean<T> {
	
	private String url;
	private Class<T> t;
	
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Class<T> getT() {
		return t;
	}

	public void setT(Class<T> t) {
		this.t = t;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getObject() throws Exception {
		JaxWsProxyFactoryBean jaxWsProxyFactoryBean  = new JaxWsProxyFactoryBean();
		jaxWsProxyFactoryBean.setAddress(url);
		jaxWsProxyFactoryBean.setServiceClass(t);
		//向jaxWsProxyFactoryBean 中放入拦截器
		Map<String,Object> hashMap = new HashMap<String,Object>();
		hashMap.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
		hashMap.put(WSHandlerConstants.USER, "user");
		hashMap.put(WSHandlerConstants.PASSWORD_TYPE, "PasswordText");
		hashMap.put(WSHandlerConstants.PW_CALLBACK_CLASS, MyCallBackClient.class.getName());
		
		WSS4JOutInterceptor wss4JOutInterceptor = new WSS4JOutInterceptor(hashMap);
		jaxWsProxyFactoryBean.getOutInterceptors().add(wss4JOutInterceptor);
		T create = (T) jaxWsProxyFactoryBean.create();
		return create;
	}

	@Override
	public Class<?> getObjectType() {
		
		return this.t;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	

}
