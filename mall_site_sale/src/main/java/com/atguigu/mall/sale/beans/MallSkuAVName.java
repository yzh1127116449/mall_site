package com.atguigu.mall.sale.beans;

public class MallSkuAVName {
	
	private String shxmMch;
	private String shxzhMch;
	public String getShxmMch() {
		return shxmMch;
	}
	public void setShxmMch(String shxmMch) {
		this.shxmMch = shxmMch;
	}
	public String getShxzhMch() {
		return shxzhMch;
	}
	public void setShxzhMch(String shxzhMch) {
		this.shxzhMch = shxzhMch;
	}
	@Override
	public String toString() {
		return "MallSkuAVName [shxmMch=" + shxmMch + ", shxzhMch=" + shxzhMch + "]";
	}
	
}
