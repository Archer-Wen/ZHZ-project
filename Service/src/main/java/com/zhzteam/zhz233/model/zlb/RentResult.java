package com.zhzteam.zhz233.model.zlb;

import java.io.Serializable;

public class RentResult implements Serializable {
    private String goods_no;//编号
    private String account;//商家用户名
    private String goods_game;//游戏名称
    private String goods_theme;//商品主题
    private Integer goods_recomm;//商品认证等级
    private Double goods_amount;//小时
    private Double goods_compensate;//保证金
    private Integer goods_short_time;//最短时间
    private Integer goods_credit_level;//用户租用需要等级

    public String getGoods_no() {
        return goods_no;
    }

    public void setGoods_no(String goods_no) {
        this.goods_no = goods_no;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getGoods_game() {
        return goods_game;
    }

    public void setGoods_game(String goods_game) {
        this.goods_game = goods_game;
    }

    public String getGoods_theme() {
        return goods_theme;
    }

    public void setGoods_theme(String goods_theme) {
        this.goods_theme = goods_theme;
    }

    public Integer getGoods_recomm() {
        return goods_recomm;
    }

    public void setGoods_recomm(Integer goods_recomm) {
        this.goods_recomm = goods_recomm;
    }

    public Double getGoods_amount() {
        return goods_amount;
    }

    public void setGoods_amount(Double goods_amount) {
        this.goods_amount = goods_amount;
    }

    public Double getGoods_compensate() {
        return goods_compensate;
    }

    public void setGoods_compensate(Double goods_compensate) {
        this.goods_compensate = goods_compensate;
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
