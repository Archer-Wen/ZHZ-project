package com.zhzteam.zhz233.model.zlb;

import io.jsonwebtoken.Claims;

import java.io.Serializable;

public class JWTResult implements Serializable {
    /**
     *
     */
    private Claims claims;
    /**
     * 状态
     */
    private Integer status;//0：成功 1：失败 2：超时

    public Claims getClaims() {
        return claims;
    }

    public void setClaims(Claims claims) {
        this.claims = claims;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
