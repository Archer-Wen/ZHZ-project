package com.zhzteam.zhz233.model.wlh;

/**
 * @描述
 * @参数 $params
 * @返回值 $return
 * @创建人 wenliheng
 * @创建时间 2018/5/23
 */
public class ShowRentView {
    private String goods_no;
    private String goods_theme;
    private double goods_hour;
    private double goods_compensate;
    private Integer goods_recomm;
    private Integer goods_short_time;
    private Integer goods_credit_level;

    public String getGoods_no() {
        return goods_no;
    }

    public void setGoods_no(String goods_no) {
        this.goods_no = goods_no;
    }

    public String getGoods_theme() {
        return goods_theme;
    }

    public void setGoods_theme(String goods_theme) {
        this.goods_theme = goods_theme;
    }

    public double getGoods_hour() {
        return goods_hour;
    }

    public void setGoods_hour(double goods_hour) {
        this.goods_hour = goods_hour;
    }

    public double getGoods_compensate() {
        return goods_compensate;
    }

    public void setGoods_compensate(double goods_compensate) {
        this.goods_compensate = goods_compensate;
    }

    public Integer getGoods_recomm() {
        return goods_recomm;
    }

    public void setGoods_recomm(Integer goods_recomm) {
        this.goods_recomm = goods_recomm;
    }

    public Integer getGoods_short_time() {
        return goods_short_time;
    }

    public void setGoods_short_time(Integer goods_short_time) {
        this.goods_short_time = goods_short_time;
    }

    public Integer getGoods_credit_level() {
        return goods_credit_level;
    }

    public void setGoods_credit_level(Integer goods_credit_level) {
        this.goods_credit_level = goods_credit_level;
    }
}
