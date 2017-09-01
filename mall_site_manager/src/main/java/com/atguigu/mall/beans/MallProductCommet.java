package com.atguigu.mall.beans;

import java.util.Date;

public class MallProductCommet {
    private Integer id;

    private Integer yhId;

    private String plnr;

    private Date plshj;

    private Integer hpjb;

    private Integer skuId;

    private String skuMch;

    private Integer shpId;

    private String shpMch;

    private Integer ddId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYhId() {
        return yhId;
    }

    public void setYhId(Integer yhId) {
        this.yhId = yhId;
    }

    public String getPlnr() {
        return plnr;
    }

    public void setPlnr(String plnr) {
        this.plnr = plnr == null ? null : plnr.trim();
    }

    public Date getPlshj() {
        return plshj;
    }

    public void setPlshj(Date plshj) {
        this.plshj = plshj;
    }

    public Integer getHpjb() {
        return hpjb;
    }

    public void setHpjb(Integer hpjb) {
        this.hpjb = hpjb;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public String getSkuMch() {
        return skuMch;
    }

    public void setSkuMch(String skuMch) {
        this.skuMch = skuMch == null ? null : skuMch.trim();
    }

    public Integer getShpId() {
        return shpId;
    }

    public void setShpId(Integer shpId) {
        this.shpId = shpId;
    }

    public String getShpMch() {
        return shpMch;
    }

    public void setShpMch(String shpMch) {
        this.shpMch = shpMch == null ? null : shpMch.trim();
    }

    public Integer getDdId() {
        return ddId;
    }

    public void setDdId(Integer ddId) {
        this.ddId = ddId;
    }
}