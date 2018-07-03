package com.zhzteam.zhz233.model.zlb;

import java.io.Serializable;

public class PathResult implements Serializable {
    /**
     * Url
     */
    private String path;
    /**
     * 状态吗
     */
    private Integer status;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
