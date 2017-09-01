package com.atguigu.mall.sale.beans;

import java.util.Date;

public class MallProductVersion {
    private Integer id;

    private Integer shpId;

    private String shpBb;

    private Integer shfqy;

    private Date chjshj;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShpId() {
        return shpId;
    }

    public void setShpId(Integer shpId) {
        this.shpId = shpId;
    }

    public String getShpBb() {
        return shpBb;
    }

    public void setShpBb(String shpBb) {
        this.shpBb = shpBb == null ? null : shpBb.trim();
    }

    public Integer getShfqy() {
        return shfqy;
    }

    public void setShfqy(Integer shfqy) {
        this.shfqy = shfqy;
    }

    public Date getChjshj() {
        return chjshj;
    }

    public void setChjshj(Date chjshj) {
        this.chjshj = chjshj;
    }
}