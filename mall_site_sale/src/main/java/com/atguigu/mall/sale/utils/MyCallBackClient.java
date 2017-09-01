package com.atguigu.mall.sale.utils;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;

public class MyCallBackClient implements CallbackHandler{

	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		
		WSPasswordCallback wpc = (WSPasswordCallback) callbacks[0];
		wpc.setIdentifier("cxf");
		String md5 = MD5Util.md5("wss4j"+MyDateUtil.getPasswordDate());
		wpc.setPassword(md5);
	}
	
}
