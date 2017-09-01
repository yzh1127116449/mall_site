package com.atguigu.mall.beans;

import java.util.Date;

public class MallUserPay {
    private Integer id;

    private Integer yhId;

    private Integer ddId;

    private Date fkshj;

    private Double ddJe;

    private String zhfFsh;

    private String yh;

    private String yhLsh;

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

    public Integer getDdId() {
        return ddId;
    }

    public void setDdId(Integer ddId) {
        this.ddId = ddId;
    }

    public Date getFkshj() {
        return fkshj;
    }

    public void setFkshj(Date fkshj) {
        this.fkshj = fkshj;
    }

    public Double getDdJe() {
        return ddJe;
    }

    public void setDdJe(Double ddJe) {
        this.ddJe = ddJe;
    }

    public String getZhfFsh() {
        return zhfFsh;
    }

    public void setZhfFsh(String zhfFsh) {
        this.zhfFsh = zhfFsh == null ? null : zhfFsh.trim();
    }

    public String getYh() {
        return yh;
    }

    public void setYh(String yh) {
        this.yh = yh == null ? null : yh.trim();
    }

    public String getYhLsh() {
        return yhLsh;
    }

    public void setYhLsh(String yhLsh) {
        this.yhLsh = yhLsh == null ? null : yhLsh.trim();
    }
}