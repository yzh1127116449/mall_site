package com.atguigu.mall.sale.beans;

public class MallOrderPhase {
    private Integer id;

    private Integer jdh;

    private String jdmsh;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getJdh() {
        return jdh;
    }

    public void setJdh(Integer jdh) {
        this.jdh = jdh;
    }

    public String getJdmsh() {
        return jdmsh;
    }

    public void setJdmsh(String jdmsh) {
        this.jdmsh = jdmsh == null ? null : jdmsh.trim();
    }
}