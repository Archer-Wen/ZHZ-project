package com.zhzteam.zhz233.model.zlb;

import java.io.Serializable;

public class GoodsLeaseResult implements Serializable {
    private String goods_no;
    private String account_no;
    private Double goods_amount;
    private Double goods_night;
    private Double goods_day;
    private Double goods_week;

    public String getGoods_no() {
        return goods_no;
    }

    public void setGoods_no(String goods_no) {
        this.goods_no = goods_no;
    }

    public String getAccount_no() {
        return account_no;
    }

    public void setAccount_no(String account_no) {
        this.account_no = account_no;
    }

    public Double getGoods_amount() {
        return goods_amount;
    }

    public void setGoods_amount(Double goods_amount) {
        this.goods_amount = goods_amount;
    }

    public Double getGoods_night() {
        return goods_night;
    }

    public void setGoods_night(Double goods_night) {
        this.goods_night = goods_night;
    }

    public Double getGoods_day() {
        return goods_day;
    }

    public void setGoods_day(Double goods_day) {
        this.goods_day = goods_day;
    }

    public Double getGoods_week() {
        return goods_week;
    }

    public void setGoods_week(Double goods_week) {
        this.goods_week = goods_week;
    }
}
