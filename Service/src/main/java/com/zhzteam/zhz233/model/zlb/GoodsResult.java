package com.zhzteam.zhz233.model.zlb;

import java.io.Serializable;
import java.util.Date;

public class GoodsResult implements Serializable {
    private String goods_no;//编号
    private String account;//发布人
    private String goods_game;//游戏名称
    private Double goods_amount;//价格
    private Integer goods_type;//商品类型（0/测试商品 1/出租商品 2/买卖商品 3/代练商品 4/其他商品）
    private String goods_theme;//商品主题
    private String goods_content;//描述
    private Integer goods_recomm;//商品等级( /0 个人认证/ 1 商家认证/ 2 个人商家认证 /3 特价商品 /4 测试认证)
    private Date create_time;

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

    public Double getGoods_amount() {
        return goods_amount;
    }

    public void setGoods_amount(Double goods_amount) {
        this.goods_amount = goods_amount;
    }

    public Integer getGoods_type() {
        return goods_type;
    }

    public void setGoods_type(Integer goods_type) {
        this.goods_type = goods_type;
    }

    public String getGoods_theme() {
        return goods_theme;
    }

    public void setGoods_theme(String goods_theme) {
        this.goods_theme = goods_theme;
    }

    public String getGoods_content() {
        return goods_content;
    }

    public void setGoods_content(String goods_content) {
        this.goods_content = goods_content;
    }

    public Integer getGoods_recomm() {
        return goods_recomm;
    }

    public void setGoods_recomm(Integer goods_recomm) {
        this.goods_recomm = goods_recomm;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
