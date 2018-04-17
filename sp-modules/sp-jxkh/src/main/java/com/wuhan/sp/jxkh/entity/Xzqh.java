package com.wuhan.sp.jxkh.entity;

import javax.persistence.*;

@Table(name = "whcg_zd_xzqh")
public class Xzqh {
    @Id
    @Column(name = "ID")
    private Integer id;

    /**
     * 行政区划
     */
    @Column(name = "XZQH")
    private String xzqh;

    /**
     * 1:中心城区 2:新城区 3:开发区
     */
    @Column(name = "QYHF")
    private String qyhf;

    /**
     * @return ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取行政区划
     *
     * @return XZQH - 行政区划
     */
    public String getXzqh() {
        return xzqh;
    }

    /**
     * 设置行政区划
     *
     * @param xzqh 行政区划
     */
    public void setXzqh(String xzqh) {
        this.xzqh = xzqh;
    }

    /**
     * 获取1:中心城区 2:新城区 3:开发区
     *
     * @return QYHF - 1:中心城区 2:新城区 3:开发区
     */
    public String getQyhf() {
        return qyhf;
    }

    /**
     * 设置1:中心城区 2:新城区 3:开发区
     *
     * @param qyhf 1:中心城区 2:新城区 3:开发区
     */
    public void setQyhf(String qyhf) {
        this.qyhf = qyhf;
    }
}