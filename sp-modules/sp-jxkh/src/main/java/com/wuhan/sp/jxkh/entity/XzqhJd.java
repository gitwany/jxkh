package com.wuhan.sp.jxkh.entity;

import javax.persistence.*;

@Table(name = "whcg_zd_xzqh_jd")
public class XzqhJd {
    @Id
    @Column(name = "ID")
    private Integer id;

    /**
     * 行政区划
     */
    @Column(name = "XZQH")
    private String xzqh;

    /**
     * 区名
     */
    @Column(name = "QM")
    private String qm;

    /**
     * 街名
     */
    @Column(name = "JM")
    private String jm;

    /**
     * 道路长度
     */
    @Column(name = "DLCD")
    private Integer dlcd;

    /**
     * 门店数
     */
    @Column(name = "MDS")
    private Integer mds;

    /**
     * 社区数
     */
    @Column(name = "SQS")
    private Integer sqs;

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
     * 获取区名
     *
     * @return QM - 区名
     */
    public String getQm() {
        return qm;
    }

    /**
     * 设置区名
     *
     * @param qm 区名
     */
    public void setQm(String qm) {
        this.qm = qm;
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
     * 获取道路长度
     *
     * @return DLCD - 道路长度
     */
    public Integer getDlcd() {
        return dlcd;
    }

    /**
     * 设置道路长度
     *
     * @param dlcd 道路长度
     */
    public void setDlcd(Integer dlcd) {
        this.dlcd = dlcd;
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
     * 获取社区数
     *
     * @return SQS - 社区数
     */
    public Integer getSqs() {
        return sqs;
    }

    /**
     * 设置社区数
     *
     * @param sqs 社区数
     */
    public void setSqs(Integer sqs) {
        this.sqs = sqs;
    }
}