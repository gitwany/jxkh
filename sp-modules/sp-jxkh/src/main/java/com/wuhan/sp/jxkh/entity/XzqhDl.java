package com.wuhan.sp.jxkh.entity;

import javax.persistence.*;

@Table(name = "whcg_zd_xzqh_dl")
public class XzqhDl {
    @Id
    @Column(name = "ID")
    private Integer id;

    /**
     * 行政区划
     */
    @Column(name = "XZQH")
    private String xzqh;

    /**
     * 街名
     */
    @Column(name = "JM")
    private String jm;

    /**
     * 序号
     */
    @Column(name = "XH")
    private Integer xh;

    /**
     * 单元名称
     */
    @Column(name = "DYMC")
    private String dymc;

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
    @Column(name = "CD")
    private Integer cd;

    /**
     * 门店数
     */
    @Column(name = "MDS")
    private Integer mds;

    /**
     * 备注
     */
    @Column(name = "BZ")
    private String bz;

    /**
     * 社区
     */
    @Column(name = "SQ")
    private String sq;

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
     * 获取街名
     *
     * @return JM - 街名
     */
    public String getJm() {
        return jm;
    }

    /**
     * 设置街名
     *
     * @param jm 街名
     */
    public void setJm(String jm) {
        this.jm = jm;
    }

    /**
     * 获取序号
     *
     * @return XH - 序号
     */
    public Integer getXh() {
        return xh;
    }

    /**
     * 设置序号
     *
     * @param xh 序号
     */
    public void setXh(Integer xh) {
        this.xh = xh;
    }

    /**
     * 获取单元名称
     *
     * @return DYMC - 单元名称
     */
    public String getDymc() {
        return dymc;
    }

    /**
     * 设置单元名称
     *
     * @param dymc 单元名称
     */
    public void setDymc(String dymc) {
        this.dymc = dymc;
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
     * @return CD - 长度（M）
     */
    public Integer getCd() {
        return cd;
    }

    /**
     * 设置长度（M）
     *
     * @param cd 长度（M）
     */
    public void setCd(Integer cd) {
        this.cd = cd;
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

    /**
     * 获取社区
     *
     * @return SQ - 社区
     */
    public String getSq() {
        return sq;
    }

    /**
     * 设置社区
     *
     * @param sq 社区
     */
    public void setSq(String sq) {
        this.sq = sq;
    }
}