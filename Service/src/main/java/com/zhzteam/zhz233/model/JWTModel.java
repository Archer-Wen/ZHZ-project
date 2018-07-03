package com.zhzteam.zhz233.model;

import java.io.Serializable;

public class JWTModel implements Serializable {
    /**
     * iss: 该JWT的签发者
     */
    private String iss;
    /**
     * jwt所面向的用户
     */
    private String sub;
    /**
     * sub: 接收jwt的一方
     */
    private String aud;
    /**
     * exp(expires): token什么时候过期
     */
    private String exp;
    /**
     * nbf: 定义在什么时间之前，该jwt都是不可用的.
     */
    private String nbf;
    /**
     * iat(issued at): 在什么时候签发的token
     */
    private String iat;
    /**
     * jti：JWT ID为web token提供唯一标识
     */
    private String jti;

    public String getIss() {
        return iss;
    }

    public void setIss(String iss) {
        this.iss = iss;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getAud() {
        return aud;
    }

    public void setAud(String aud) {
        this.aud = aud;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getNbf() {
        return nbf;
    }

    public void setNbf(String nbf) {
        this.nbf = nbf;
    }

    public String getIat() {
        return iat;
    }

    public void setIat(String iat) {
        this.iat = iat;
    }

    public String getJti() {
        return jti;
    }

    public void setJti(String jti) {
        this.jti = jti;
    }
}
