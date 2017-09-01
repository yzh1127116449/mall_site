package com.atguigu.mall.sale.beans;

import java.util.Date;

public class MallUserInfo {
    private Integer idCard;

    private Integer yhId;

    private String yhShjh;

    private String yhJg;

    private String yhZhzh;

    private Integer yhXb;

    private Date chjshj;

    public Integer getIdCard() {
        return idCard;
    }

    public void setIdCard(Integer idCard) {
        this.idCard = idCard;
    }

    public Integer getYhId() {
        return yhId;
    }

    public void setYhId(Integer yhId) {
        this.yhId = yhId;
    }

    public String getYhShjh() {
        return yhShjh;
    }

    public void setYhShjh(String yhShjh) {
        this.yhShjh = yhShjh == null ? null : yhShjh.trim();
    }

    public String getYhJg() {
        return yhJg;
    }

    public void setYhJg(String yhJg) {
        this.yhJg = yhJg == null ? null : yhJg.trim();
    }

    public String getYhZhzh() {
        return yhZhzh;
    }

    public void setYhZhzh(String yhZhzh) {
        this.yhZhzh = yhZhzh == null ? null : yhZhzh.trim();
    }

    public Integer getYhXb() {
        return yhXb;
    }

    public void setYhXb(Integer yhXb) {
        this.yhXb = yhXb;
    }

    public Date getChjshj() {
        return chjshj;
    }

    public void setChjshj(Date chjshj) {
        this.chjshj = chjshj;
    }
}