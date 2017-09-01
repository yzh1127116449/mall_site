package com.atguigu.mall.sale.beans;

import java.util.List;

public class ObjectMallFlow extends MallFlow {
	
	private String ckdz;
	
	public String getCkdz() {
		return ckdz;
	}

	public void setCkdz(String ckdz) {
		this.ckdz = ckdz;
	}

	private List<MallOrderInfo> listOrderInfo ;

	public List<MallOrderInfo> getListOrderInfo() {
		return listOrderInfo;
	}

	public void setListOrderInfo(List<MallOrderInfo> listOrderInfo) {
		this.listOrderInfo = listOrderInfo;
	}

	
	
}
