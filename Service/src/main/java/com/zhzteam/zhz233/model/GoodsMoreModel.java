package com.zhzteam.zhz233.model;

import java.io.Serializable;

public class GoodsMoreModel implements Serializable {
    private Long id;
    private String goods_no;
    private String goods_game;
    private String goods_role;
    private String goods_area;
    private String goods_server;
    private Integer goods_grade;
    private Integer goods_rank;
    private Integer goods_case;
    private Integer goods_access;
    private String goods_skin;
    private String goods_hero;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoods_no() {
        return goods_no;
    }

    public void setGoods_no(String goods_no) {
        this.goods_no = goods_no;
    }

    public String getGoods_game() {
        return goods_game;
    }

    public void setGoods_game(String goods_game) {
        this.goods_game = goods_game;
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

    public Integer getGoods_access() {
        return goods_access;
    }

    public void setGoods_access(Integer goods_access) {
        this.goods_access = goods_access;
    }

    public String getGoods_skin() {
        return goods_skin;
    }

    public void setGoods_skin(String goods_skin) {
        this.goods_skin = goods_skin;
    }

    public String getGoods_hero() {
        return goods_hero;
    }

    public void setGoods_hero(String goods_hero) {
        this.goods_hero = goods_hero;
    }
}
