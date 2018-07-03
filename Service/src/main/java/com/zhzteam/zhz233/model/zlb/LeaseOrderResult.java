package com.zhzteam.zhz233.model.zlb;

import java.io.Serializable;
import java.util.Date;

public class LeaseOrderResult implements Serializable {
    private String order_no;//订单编号 03
    private String goods_no;//商品编号
    private String account;//商家
    private String buyer;//购买者
    private Double order_amount;//总价格
    private Integer order_time;//时间（小时）
    private Date create_time;

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

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

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public Double getOrder_amount() {
        return order_amount;
    }

    public void setOrder_amount(Double order_amount) {
        this.order_amount = order_amount;
    }

    public Integer getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Integer order_time) {
        this.order_time = order_time;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
