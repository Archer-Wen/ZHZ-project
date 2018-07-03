package com.zhzteam.zhz233.model.zlb;

import java.io.Serializable;

public class RegisterInfo implements Serializable {
    /**
     * 用户名
     */
    private String username;
    /**
     * 手机号
     */
    private String cellphone;
    /**
     * 密码
     */
    private String password;
    /**
     * 验证码
     */
    private String code;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
