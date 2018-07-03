package com.zhzteam.zhz233.model.wlh;

import java.time.LocalDateTime;

/**
 * @描述
 * @参数 $params
 * @返回值 $return
 * @创建人 wenliheng
 * @创建时间 2018/5/23
 */
public class UserRentOrderView {
    private String order_no;//订单编号
    private String goods_game;//游戏名
    private String goods_access;//游戏账号
    private double order_amount;//订单金额
    private LocalDateTime order_end_time;//订单结束时间

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getGoods_access() {
        return goods_access;
    }

    public void setGoods_access(String goods_access) {
        this.goods_access = goods_access;
    }

    public double getOrder_amount() {
        return order_amount;
    }

    public void setOrder_amount(double order_amount) {
        this.order_amount = order_amount;
    }

    public LocalDateTime getOrder_end_time() {
        return order_end_time;
    }

    public void setOrder_end_time(LocalDateTime order_end_time) {
        this.order_end_time = order_end_time;
    }

    public String getGoods_game() {
        return goods_game;
    }

    public void setGoods_game(String goods_game) {
        this.goods_game = goods_game;
    }
}
