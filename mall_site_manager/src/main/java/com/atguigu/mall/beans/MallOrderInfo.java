package com.atguigu.mall.beans;

import java.util.Date;

public class MallOrderInfo {
    private Integer id;

    private Integer ddId;

    private Integer skuId;

    private Date chjshj;

    private String skuMch;

    private String shpTp;

    private Long skuJg;

    private Integer skuShl;

    private String skuKcdz;

    private Integer gwchId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDdId() {
        return ddId;
    }

    public void setDdId(Integer ddId) {
        this.ddId = ddId;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public Date getChjshj() {
        return chjshj;
    }

    public void setChjshj(Date chjshj) {
        this.chjshj = chjshj;
    }

    public String getSkuMch() {
        return skuMch;
    }

    public void setSkuMch(String skuMch) {
        this.skuMch = skuMch == null ? null : skuMch.trim();
    }

    public String getShpTp() {
        return shpTp;
    }

    public void setShpTp(String shpTp) {
        this.shpTp = shpTp == null ? null : shpTp.trim();
    }

    public Long getSkuJg() {
        return skuJg;
    }

    public void setSkuJg(Long skuJg) {
        this.skuJg = skuJg;
    }

    public Integer getSkuShl() {
        return skuShl;
    }

    public void setSkuShl(Integer skuShl) {
        this.skuShl = skuShl;
    }

    public String getSkuKcdz() {
        return skuKcdz;
    }

    public void setSkuKcdz(String skuKcdz) {
        this.skuKcdz = skuKcdz == null ? null : skuKcdz.trim();
    }

    public Integer getGwchId() {
        return gwchId;
    }

    public void setGwchId(Integer gwchId) {
        this.gwchId = gwchId;
    }
}