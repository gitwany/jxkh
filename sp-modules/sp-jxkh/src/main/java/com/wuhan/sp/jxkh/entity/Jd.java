package com.wuhan.sp.jxkh.entity;

import javax.persistence.*;

@Table(name = "whcg_zd_jd")
public class Jd {
    /**
     * 问题分类-主键
     */
    @Id
    @Column(name = "ID")
    private Integer id;

    /**
     * 街道编码
     */
    @Column(name = "JDBM")
    private String jdbm;

    /**
     * 街道名称
     */
    @Column(name = "JDMC")
    private String jdmc;

    /**
     * 街道区划
     */
    @Column(name = "JDQH")
    private String jdqh;

    /**
     * 获取问题分类-主键
     *
     * @return ID - 问题分类-主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置问题分类-主键
     *
     * @param id 问题分类-主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取街道编码
     *
     * @return JDBM - 街道编码
     */
    public String getJdbm() {
        return jdbm;
    }

    /**
     * 设置街道编码
     *
     * @param jdbm 街道编码
     */
    public void setJdbm(String jdbm) {
        this.jdbm = jdbm;
    }

    /**
     * 获取街道名称
     *
     * @return JDMC - 街道名称
     */
    public String getJdmc() {
        return jdmc;
    }

    /**
     * 设置街道名称
     *
     * @param jdmc 街道名称
     */
    public void setJdmc(String jdmc) {
        this.jdmc = jdmc;
    }

    /**
     * 获取街道区划
     *
     * @return JDQH - 街道区划
     */
    public String getJdqh() {
        return jdqh;
    }

    /**
     * 设置街道区划
     *
     * @param jdqh 街道区划
     */
    public void setJdqh(String jdqh) {
        this.jdqh = jdqh;
    }
}