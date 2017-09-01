package com.atguigu.mall.beans;

import java.util.Date;

public class MallOrder {
    private Integer id;

    private String shhr;

    private Long zje;

    private Integer jdh;

    private Integer yhId;

    private Date chjshj;

    private Date yjsdshj;

    private Integer dzhId;

    private String dzhMch;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShhr() {
        return shhr;
    }

    public void setShhr(String shhr) {
        this.shhr = shhr == null ? null : shhr.trim();
    }

    public Long getZje() {
        return zje;
    }

    public void setZje(Long zje) {
        this.zje = zje;
    }

    public Integer getJdh() {
        return jdh;
    }

    public void setJdh(Integer jdh) {
        this.jdh = jdh;
    }

    public Integer getYhId() {
        return yhId;
    }

    public void setYhId(Integer yhId) {
        this.yhId = yhId;
    }

    public Date getChjshj() {
        return chjshj;
    }

    public void setChjshj(Date chjshj) {
        this.chjshj = chjshj;
    }

    public Date getYjsdshj() {
        return yjsdshj;
    }

    public void setYjsdshj(Date yjsdshj) {
        this.yjsdshj = yjsdshj;
    }

    public Integer getDzhId() {
        return dzhId;
    }

    public void setDzhId(Integer dzhId) {
        this.dzhId = dzhId;
    }

    public String getDzhMch() {
        return dzhMch;
    }

    public void setDzhMch(String dzhMch) {
        this.dzhMch = dzhMch == null ? null : dzhMch.trim();
    }
}