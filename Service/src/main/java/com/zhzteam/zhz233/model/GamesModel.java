package com.zhzteam.zhz233.model;

import java.io.Serializable;

public class GamesModel implements Serializable {
    private Long id;//自增id
    private String games_no;//游戏no
    private Integer games_type;//1:端游 2： 页游 3：手游
    private String games_name;//游戏名称
    private Integer games_recomm;//游戏热度

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGames_no() {
        return games_no;
    }

    public void setGames_no(String games_no) {
        this.games_no = games_no;
    }

    public Integer getGames_type() {
        return games_type;
    }

    public void setGames_type(Integer games_type) {
        this.games_type = games_type;
    }

    public String getGames_name() {
        return games_name;
    }

    public void setGames_name(String games_name) {
        this.games_name = games_name;
    }

    public Integer getGames_recomm() {
        return games_recomm;
    }

    public void setGames_recomm(Integer games_recomm) {
        this.games_recomm = games_recomm;
    }
}
