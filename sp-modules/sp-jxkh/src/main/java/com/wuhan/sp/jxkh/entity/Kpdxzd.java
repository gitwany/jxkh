package com.wuhan.sp.jxkh.entity;

import java.util.List;

public class Kpdxzd {
    private Integer id;

    private String kplb;

    private List<Kpxx> data;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKplb() {
        return kplb;
    }

    public void setKplb(String kplb) {
        this.kplb = kplb;
    }

    public List<Kpxx> getData() {
        return data;
    }

    public void setData(List<Kpxx> data) {
        this.data = data;
    }

    public Kpdxzd() {

    }

    public Kpdxzd(Integer id, String kplb) {
        this.id = id;
        this.kplb = kplb;
    }
}
