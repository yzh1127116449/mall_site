package com.atguigu.test;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.atguigu.mall.sale.beans.MallUserAccount;
import com.atguigu.mall.sale.service.UserService;


public class TestCxf {

	public static void main(String[] args) {
		JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
		jaxWsProxyFactoryBean.setAddress("http://localhost:8080/mall_site_user_service/user?wsdl");
		jaxWsProxyFactoryBean.setServiceClass(UserService.class);
		UserService create = (UserService) jaxWsProxyFactoryBean.create();
		MallUserAccount user = new MallUserAccount();
		user.setYhMch("admin");
		user.setYhMm("123");
		MallUserAccount userLogin = create.doLogin(user);
		System.out.println(userLogin);
	}

}
