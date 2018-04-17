package com.wuhan.sp.workflow.entity;

import javax.persistence.*;

@Table(name = "whcg_tb_wtsb")
public class Wtsb {
    /**
     * 问题序号
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 行政区划
     */
    @Column(name = "XZQH")
    private String xzqh;

    /**
     * 考评类别（一级字典）
     */
    @Column(name = "KPLB")
    private Integer kplb;

    /**
     * 街道代码
     */
    @Column(name = "JDDM")
    private String jddm;

    /**
     * 道路代码
     */
    @Column(name = "DLDM")
    private String dldm;

    /**
     * 考评大项
     */
    @Column(name = "KPDX")
    private Integer kpdx;

    /**
     * 考评小项
     */
    @Column(name = "KPXX")
    private Integer kpxx;

    /**
     * 计量
     */
    @Column(name = "JL")
    private Integer jl;

    /**
     * 整改前照片
     */
    @Column(name = "ZGQZP")
    private String zgqzp;

    /**
     * 整改后照片
     */
    @Column(name = "ZGHZP")
    private String zghzp;

    /**
     * 修正照片
     */
    @Column(name = "XZZP")
    private String xzzp;

    /**
     * 状态
     */
    @Column(name = "ZT")
    private String zt;

    /**
     * 分配地址
     */
    @Column(name = "FP")
    private String fp;

    /**
     * 获取问题序号
     *
     * @return ID - 问题序号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置问题序号
     *
     * @param id 问题序号
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
     * 获取考评类别（一级字典）
     *
     * @return KPLB - 考评类别（一级字典）
     */
    public Integer getKplb() {
        return kplb;
    }

    /**
     * 设置考评类别（一级字典）
     *
     * @param kplb 考评类别（一级字典）
     */
    public void setKplb(Integer kplb) {
        this.kplb = kplb;
    }

    /**
     * 获取街道代码
     *
     * @return JDDM - 街道代码
     */
    public String getJddm() {
        return jddm;
    }

    /**
     * 设置街道代码
     *
     * @param jddm 街道代码
     */
    public void setJddm(String jddm) {
        this.jddm = jddm;
    }

    /**
     * 获取道路代码
     *
     * @return DLDM - 道路代码
     */
    public String getDldm() {
        return dldm;
    }

    /**
     * 设置道路代码
     *
     * @param dldm 道路代码
     */
    public void setDldm(String dldm) {
        this.dldm = dldm;
    }

    /**
     * 获取考评大项
     *
     * @return KPDX - 考评大项
     */
    public Integer getKpdx() {
        return kpdx;
    }

    /**
     * 设置考评大项
     *
     * @param kpdx 考评大项
     */
    public void setKpdx(Integer kpdx) {
        this.kpdx = kpdx;
    }

    /**
     * 获取考评小项
     *
     * @return KPXX - 考评小项
     */
    public Integer getKpxx() {
        return kpxx;
    }

    /**
     * 设置考评小项
     *
     * @param kpxx 考评小项
     */
    public void setKpxx(Integer kpxx) {
        this.kpxx = kpxx;
    }

    /**
     * 获取计量
     *
     * @return JL - 计量
     */
    public Integer getJl() {
        return jl;
    }

    /**
     * 设置计量
     *
     * @param jl 计量
     */
    public void setJl(Integer jl) {
        this.jl = jl;
    }

    /**
     * 获取整改前照片
     *
     * @return ZGQZP - 整改前照片
     */
    public String getZgqzp() {
        return zgqzp;
    }

    /**
     * 设置整改前照片
     *
     * @param zgqzp 整改前照片
     */
    public void setZgqzp(String zgqzp) {
        this.zgqzp = zgqzp;
    }

    /**
     * 获取整改后照片
     *
     * @return ZGHZP - 整改后照片
     */
    public String getZghzp() {
        return zghzp;
    }

    /**
     * 设置整改后照片
     *
     * @param zghzp 整改后照片
     */
    public void setZghzp(String zghzp) {
        this.zghzp = zghzp;
    }

    /**
     * 获取修正照片
     *
     * @return XZZP - 修正照片
     */
    public String getXzzp() {
        return xzzp;
    }

    /**
     * 设置修正照片
     *
     * @param xzzp 修正照片
     */
    public void setXzzp(String xzzp) {
        this.xzzp = xzzp;
    }

    /**
     * 获取状态
     *
     * @return ZT - 状态
     */
    public String getZt() {
        return zt;
    }

    /**
     * 设置状态
     *
     * @param zt 状态
     */
    public void setZt(String zt) {
        this.zt = zt;
    }

    /**
     * 获取分配地址
     *
     * @return FP - 分配地址
     */
    public String getFp() {
        return fp;
    }

    /**
     * 设置分配地址
     *
     * @param fp 分配地址
     */
    public void setFp(String fp) {
        this.fp = fp;
    }
}