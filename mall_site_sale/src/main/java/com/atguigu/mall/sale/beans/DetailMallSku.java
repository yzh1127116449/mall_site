package com.atguigu.mall.sale.beans;

import java.util.List;
/**
 * 用于封装商品详情信息
 * @author Tink
 *
 */
public class DetailMallSku extends MallSku {
	
	private MallProduct spu;
	private MallTradeMark tm;
	private List<MallProductImage> list_image;
	private List<MallSkuAVName> list_av_name;
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
	public List<MallProductImage> getList_image() {
		return list_image;
	}
	public void setList_image(List<MallProductImage> list_image) {
		this.list_image = list_image;
	}
	public List<MallSkuAVName> getList_av_name() {
		return list_av_name;
	}
	public void setList_av_name(List<MallSkuAVName> list_av_name) {
		this.list_av_name = list_av_name;
	}
	@Override
	public String toString() {
		return "DetailMallSku [spu=" + spu + ", tm=" + tm + ", list_image=" + list_image + ", list_av_name="
				+ list_av_name + "]";
	}
	
	
	
}
