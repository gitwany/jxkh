package com.wuhan.sp.jxkh.entity;

import javax.persistence.*;

@Table(name = "whcg_zd_zcgd")
public class Zcgd {
    @Id
    @Column(name = "ID")
    private Integer id;

    /**
     * 主次干道编码
     */
    @Column(name = "ZCGDBM")
    private String zcgdbm;

    /**
     * 主次干道名称
     */
    @Column(name = "ZCGDMC")
    private String zcgdmc;

    /**
     * 区划编码
     */
    @Column(name = "QHBM")
    private String qhbm;

    /**
     * 区划编码
     */
    @Column(name = "QH")
    private String qh;

    /**
     * 起点
     */
    @Column(name = "QD")
    private String qd;

    /**
     * 止点
     */
    @Column(name = "ZD")
    private String zd;

    /**
     * 长度（M）
     */
    @Column(name = "LC")
    private Integer lc;

    /**
     * 门店数
     */
    @Column(name = "MDS")
    private Integer mds;

    /**
     * 类别
     */
    @Column(name = "LB")
    private String lb;

    /**
     * 备注
     */
    @Column(name = "BZ")
    private String bz;

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
     * 获取主次干道编码
     *
     * @return ZCGDBM - 主次干道编码
     */
    public String getZcgdbm() {
        return zcgdbm;
    }

    /**
     * 设置主次干道编码
     *
     * @param zcgdbm 主次干道编码
     */
    public void setZcgdbm(String zcgdbm) {
        this.zcgdbm = zcgdbm;
    }

    /**
     * 获取主次干道名称
     *
     * @return ZCGDMC - 主次干道名称
     */
    public String getZcgdmc() {
        return zcgdmc;
    }

    /**
     * 设置主次干道名称
     *
     * @param zcgdmc 主次干道名称
     */
    public void setZcgdmc(String zcgdmc) {
        this.zcgdmc = zcgdmc;
    }

    /**
     * 获取区划编码
     *
     * @return QHBM - 区划编码
     */
    public String getQhbm() {
        return qhbm;
    }

    /**
     * 设置区划编码
     *
     * @param qhbm 区划编码
     */
    public void setQhbm(String qhbm) {
        this.qhbm = qhbm;
    }

    /**
     * 获取区划编码
     *
     * @return QH - 区划编码
     */
    public String getQh() {
        return qh;
    }

    /**
     * 设置区划编码
     *
     * @param qh 区划编码
     */
    public void setQh(String qh) {
        this.qh = qh;
    }

    /**
     * 获取起点
     *
     * @return QD - 起点
     */
    public String getQd() {
        return qd;
    }

    /**
     * 设置起点
     *
     * @param qd 起点
     */
    public void setQd(String qd) {
        this.qd = qd;
    }

    /**
     * 获取止点
     *
     * @return ZD - 止点
     */
    public String getZd() {
        return zd;
    }

    /**
     * 设置止点
     *
     * @param zd 止点
     */
    public void setZd(String zd) {
        this.zd = zd;
    }

    /**
     * 获取长度（M）
     *
     * @return LC - 长度（M）
     */
    public Integer getLc() {
        return lc;
    }

    /**
     * 设置长度（M）
     *
     * @param lc 长度（M）
     */
    public void setLc(Integer lc) {
        this.lc = lc;
    }

    /**
     * 获取门店数
     *
     * @return MDS - 门店数
     */
    public Integer getMds() {
        return mds;
    }

    /**
     * 设置门店数
     *
     * @param mds 门店数
     */
    public void setMds(Integer mds) {
        this.mds = mds;
    }

    /**
     * 获取类别
     *
     * @return LB - 类别
     */
    public String getLb() {
        return lb;
    }

    /**
     * 设置类别
     *
     * @param lb 类别
     */
    public void setLb(String lb) {
        this.lb = lb;
    }

    /**
     * 获取备注
     *
     * @return BZ - 备注
     */
    public String getBz() {
        return bz;
    }

    /**
     * 设置备注
     *
     * @param bz 备注
     */
    public void setBz(String bz) {
        this.bz = bz;
    }
}