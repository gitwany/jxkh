package com.wuhan.sp.jxkh.entity;

import javax.persistence.*;

@Table(name = "whcg_zd_khqh")
public class Khqh {
    @Id
    @Column(name = "ID")
    private Integer id;

    /**
     * 区划编码
     */
    @Column(name = "QHBM")
    private String qhbm;

    /**
     * 考核对象
     */
    @Column(name = "KHDX")
    private String khdx;

    /**
     * 区划属性
     */
    @Column(name = "QHSX")
    private String qhsx;

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
     * 获取考核对象
     *
     * @return KHDX - 考核对象
     */
    public String getKhdx() {
        return khdx;
    }

    /**
     * 设置考核对象
     *
     * @param khdx 考核对象
     */
    public void setKhdx(String khdx) {
        this.khdx = khdx;
    }

    /**
     * 获取区划属性
     *
     * @return QHSX - 区划属性
     */
    public String getQhsx() {
        return qhsx;
    }

    /**
     * 设置区划属性
     *
     * @param qhsx 区划属性
     */
    public void setQhsx(String qhsx) {
        this.qhsx = qhsx;
    }
}