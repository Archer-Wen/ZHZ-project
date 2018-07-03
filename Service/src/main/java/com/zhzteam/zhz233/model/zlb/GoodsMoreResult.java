package com.zhzteam.zhz233.model.zlb;

import java.io.Serializable;

public class GoodsMoreResult implements Serializable {
    private String goods_no;
    private String goods_role;
    private String goods_area;
    private String goods_server;
    private Integer goods_grade;
    private Integer goods_rank;
    private Integer goods_case;

    public String getGoods_no() {
        return goods_no;
    }

    public void setGoods_no(String goods_no) {
        this.goods_no = goods_no;
    }

    public String getGoods_role() {
        return goods_role;
    }

    public void setGoods_role(String goods_role) {
        this.goods_role = goods_role;
    }

    public String getGoods_area() {
        return goods_area;
    }

    public void setGoods_area(String goods_area) {
        this.goods_area = goods_area;
    }

    public String getGoods_server() {
        return goods_server;
    }

    public void setGoods_server(String goods_server) {
        this.goods_server = goods_server;
    }

    public Integer getGoods_grade() {
        return goods_grade;
    }

    public void setGoods_grade(Integer goods_grade) {
        this.goods_grade = goods_grade;
    }

    public Integer getGoods_rank() {
        return goods_rank;
    }

    public void setGoods_rank(Integer goods_rank) {
        this.goods_rank = goods_rank;
    }

    public Integer getGoods_case() {
        return goods_case;
    }

    public void setGoods_case(Integer goods_case) {
        this.goods_case = goods_case;
    }
}
