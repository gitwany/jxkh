package com.wuhan.sp.jxkh.entity;

import javax.persistence.*;

@Table(name = "whcg_zd_kplb")
public class Kplb {
    /**
     * 问题分类-主键
     */
    @Id
    @Column(name = "ID")
    private Integer id;

    /**
     * 考核类别（此处是一级考核）
     */
    @Column(name = "KPLB")
    private String kplb;

    /**
     * 考评大项（逗号分隔）
     */
    @Column(name = "KPDXS")
    private String kpdxs;

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
     * 获取考核类别（此处是一级考核）
     *
     * @return KPLB - 考核类别（此处是一级考核）
     */
    public String getKplb() {
        return kplb;
    }

    /**
     * 设置考核类别（此处是一级考核）
     *
     * @param kplb 考核类别（此处是一级考核）
     */
    public void setKplb(String kplb) {
        this.kplb = kplb;
    }

    /**
     * 获取考评大项（逗号分隔）
     *
     * @return KPDXS - 考评大项（逗号分隔）
     */
    public String getKpdxs() {
        return kpdxs;
    }

    /**
     * 设置考评大项（逗号分隔）
     *
     * @param kpdxs 考评大项（逗号分隔）
     */
    public void setKpdxs(String kpdxs) {
        this.kpdxs = kpdxs;
    }
}