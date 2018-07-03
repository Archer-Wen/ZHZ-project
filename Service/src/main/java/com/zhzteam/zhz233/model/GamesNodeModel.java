package com.zhzteam.zhz233.model;

import java.io.Serializable;

public class GamesNodeModel implements Serializable {
    private Integer id;//编号
    private String node_name;//节点名称
    private Integer node_no;//节点编号
    private Integer node_level;//层次

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNode_name() {
        return node_name;
    }

    public void setNode_name(String node_name) {
        this.node_name = node_name;
    }

    public Integer getNode_no() {
        return node_no;
    }

    public void setNode_no(Integer node_no) {
        this.node_no = node_no;
    }

    public Integer getNode_level() {
        return node_level;
    }

    public void setNode_level(Integer node_level) {
        this.node_level = node_level;
    }
}
