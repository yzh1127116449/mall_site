package com.atguigu.mall.sale.beans;

import java.util.List;

public class ObjectMallSku extends MallSku {
	private MallProduct spu;
	private MallTradeMark tm;
	private List<MallSkuAttrValue> list_av;
	public MallProduct getSpu() {
		return spu;
	}
	public void setSpu(MallProduct spu) {
		this.spu = spu;
	}
	public MallTradeMark getTm() {
		return tm;
	}
	public void setTm(MallTradeMark tm) {
		this.tm = tm;
	}
	public List<MallSkuAttrValue> getList_av() {
		return list_av;
	}
	public void setList_av(List<MallSkuAttrValue> list_av) {
		this.list_av = list_av;
	}
	
}
