package com.atguigu.mall.beans;

import java.util.Date;

public class MallProductColor {
    private Integer id;

    private Integer shpId;

    private String shpYs;

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

    public String getShpYs() {
        return shpYs;
    }

    public void setShpYs(String shpYs) {
        this.shpYs = shpYs == null ? null : shpYs.trim();
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