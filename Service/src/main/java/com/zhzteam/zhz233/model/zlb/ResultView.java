package com.zhzteam.zhz233.model.zlb;

import java.util.Map;

public class ResultView {
    /**
     *  状态码
     */
    private Integer status;//0：失败 1：成功
    /**
     * 提示信息
     */
    private String message;

    /**
     * 内容
     */
    private Map<String,Object> reMap;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getReMap() {
        return reMap;
    }

    public void setReMap(Map<String, Object> reMap) {
        this.reMap = reMap;
    }
}
