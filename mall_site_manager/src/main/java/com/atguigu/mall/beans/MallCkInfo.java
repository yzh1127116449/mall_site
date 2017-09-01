package com.atguigu.mall.beans;

public class MallCkInfo {
    private Integer id;

    private String ckMch;

    private String ckDz;

    private String ckLx;

    private Double ckMj;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCkMch() {
        return ckMch;
    }

    public void setCkMch(String ckMch) {
        this.ckMch = ckMch == null ? null : ckMch.trim();
    }

    public String getCkDz() {
        return ckDz;
    }

    public void setCkDz(String ckDz) {
        this.ckDz = ckDz == null ? null : ckDz.trim();
    }

    public String getCkLx() {
        return ckLx;
    }

    public void setCkLx(String ckLx) {
        this.ckLx = ckLx == null ? null : ckLx.trim();
    }

    public Double getCkMj() {
        return ckMj;
    }

    public void setCkMj(Double ckMj) {
        this.ckMj = ckMj;
    }
}