package com.wuhan.sp.jxkh.entity;

import java.util.List;

/**
 * 考评字典
 */
public class Kpzd {

    private Integer id;

    private String kplb;

    private List<Kpdxzd> data;

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

    public List<Kpdxzd> getData() {
        return data;
    }

    public void setData(List<Kpdxzd> data) {
        this.data = data;
    }

    public Kpzd() {

    }

    public Kpzd(Integer id, String kplb) {
        this.id = id;
        this.kplb = kplb;
    }

    public Kpzd(Integer id, String kplb, List<Kpdxzd> data) {
        this.id = id;
        this.kplb = kplb;
        this.data = data;
    }
}
