package com.wuhan.sp.jxkh.entity;

import javax.persistence.*;

@Table(name = "whcg_zd_kpdx")
public class Kpdx {
    /**
     * 问题分类-主键
     */
    @Id
    @Column(name = "ID")
    private Integer id;

    /**
     * 考核类别（此处是二级考核）
     */
    @Column(name = "KPLB")
    private String kplb;

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
     * 获取考核类别（此处是二级考核）
     *
     * @return KPLB - 考核类别（此处是二级考核）
     */
    public String getKplb() {
        return kplb;
    }

    /**
     * 设置考核类别（此处是二级考核）
     *
     * @param kplb 考核类别（此处是二级考核）
     */
    public void setKplb(String kplb) {
        this.kplb = kplb;
    }
}