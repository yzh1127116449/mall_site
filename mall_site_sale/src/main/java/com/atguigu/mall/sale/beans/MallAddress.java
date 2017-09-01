package com.atguigu.mall.sale.beans;

public class MallAddress {
    private Integer id;

    private String dzMch;

    private Integer dzzt;

    private Integer yhId;

    private String shjr;

    private String lxfsh;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDzMch() {
        return dzMch;
    }

    public void setDzMch(String dzMch) {
        this.dzMch = dzMch == null ? null : dzMch.trim();
    }

    public Integer getDzzt() {
        return dzzt;
    }

    public void setDzzt(Integer dzzt) {
        this.dzzt = dzzt;
    }

    public Integer getYhId() {
        return yhId;
    }

    public void setYhId(Integer yhId) {
        this.yhId = yhId;
    }

    public String getShjr() {
        return shjr;
    }

    public void setShjr(String shjr) {
        this.shjr = shjr == null ? null : shjr.trim();
    }

    public String getLxfsh() {
        return lxfsh;
    }

    public void setLxfsh(String lxfsh) {
        this.lxfsh = lxfsh == null ? null : lxfsh.trim();
    }
}