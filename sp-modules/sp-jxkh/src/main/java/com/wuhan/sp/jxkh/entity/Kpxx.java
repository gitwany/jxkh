package com.wuhan.sp.jxkh.entity;

import javax.persistence.*;

@Table(name = "whcg_tb_kpxx")
public class Kpxx {
    /**
     * 考评小项_三级
     */
    @Id
    @Column(name = "KPXX")
    private Integer kpxx;

    /**
     * 考评类别_一级
     */
    @Column(name = "KPLB")
    private Integer kplb;

    /**
     * 考评类别_中文
     */
    @Column(name = "KPLB_CN")
    private String kplbCn;

    /**
     * 考评大项_二级
     */
    @Column(name = "KPDX")
    private Integer kpdx;

    /**
     * 考评大项_中文
     */
    @Column(name = "KPDX_CN")
    private String kpdxCn;

    /**
     * 考评子项_中文
     */
    @Column(name = "KPXX_CN")
    private String kpxxCn;

    /**
     * 考评标准
     */
    @Column(name = "KPBZ")
    private String kpbz;

    /**
     * 计量标准
     */
    @Column(name = "JLBZ")
    private String jlbz;

    /**
     * 整改期限
     */
    @Column(name = "ZGQX")
    private String zgqx;

    /**
     * 扣分标准
     */
    @Column(name = "KFBZ")
    private String kfbz;

    /**
     * 获取考评小项_三级
     *
     * @return KPXX - 考评小项_三级
     */
    public Integer getKpxx() {
        return kpxx;
    }

    /**
     * 设置考评小项_三级
     *
     * @param kpxx 考评小项_三级
     */
    public void setKpxx(Integer kpxx) {
        this.kpxx = kpxx;
    }

    /**
     * 获取考评类别_一级
     *
     * @return KPLB - 考评类别_一级
     */
    public Integer getKplb() {
        return kplb;
    }

    /**
     * 设置考评类别_一级
     *
     * @param kplb 考评类别_一级
     */
    public void setKplb(Integer kplb) {
        this.kplb = kplb;
    }

    /**
     * 获取考评类别_中文
     *
     * @return KPLB_CN - 考评类别_中文
     */
    public String getKplbCn() {
        return kplbCn;
    }

    /**
     * 设置考评类别_中文
     *
     * @param kplbCn 考评类别_中文
     */
    public void setKplbCn(String kplbCn) {
        this.kplbCn = kplbCn;
    }

    /**
     * 获取考评大项_二级
     *
     * @return KPDX - 考评大项_二级
     */
    public Integer getKpdx() {
        return kpdx;
    }

    /**
     * 设置考评大项_二级
     *
     * @param kpdx 考评大项_二级
     */
    public void setKpdx(Integer kpdx) {
        this.kpdx = kpdx;
    }

    /**
     * 获取考评大项_中文
     *
     * @return KPDX_CN - 考评大项_中文
     */
    public String getKpdxCn() {
        return kpdxCn;
    }

    /**
     * 设置考评大项_中文
     *
     * @param kpdxCn 考评大项_中文
     */
    public void setKpdxCn(String kpdxCn) {
        this.kpdxCn = kpdxCn;
    }

    /**
     * 获取考评子项_中文
     *
     * @return KPXX_CN - 考评子项_中文
     */
    public String getKpxxCn() {
        return kpxxCn;
    }

    /**
     * 设置考评子项_中文
     *
     * @param kpxxCn 考评子项_中文
     */
    public void setKpxxCn(String kpxxCn) {
        this.kpxxCn = kpxxCn;
    }

    /**
     * 获取考评标准
     *
     * @return KPBZ - 考评标准
     */
    public String getKpbz() {
        return kpbz;
    }

    /**
     * 设置考评标准
     *
     * @param kpbz 考评标准
     */
    public void setKpbz(String kpbz) {
        this.kpbz = kpbz;
    }

    /**
     * 获取计量标准
     *
     * @return JLBZ - 计量标准
     */
    public String getJlbz() {
        return jlbz;
    }

    /**
     * 设置计量标准
     *
     * @param jlbz 计量标准
     */
    public void setJlbz(String jlbz) {
        this.jlbz = jlbz;
    }

    /**
     * 获取整改期限
     *
     * @return ZGQX - 整改期限
     */
    public String getZgqx() {
        return zgqx;
    }

    /**
     * 设置整改期限
     *
     * @param zgqx 整改期限
     */
    public void setZgqx(String zgqx) {
        this.zgqx = zgqx;
    }

    /**
     * 获取扣分标准
     *
     * @return KFBZ - 扣分标准
     */
    public String getKfbz() {
        return kfbz;
    }

    /**
     * 设置扣分标准
     *
     * @param kfbz 扣分标准
     */
    public void setKfbz(String kfbz) {
        this.kfbz = kfbz;
    }
}