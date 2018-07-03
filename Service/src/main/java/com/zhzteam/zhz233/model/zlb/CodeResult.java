package com.zhzteam.zhz233.model.zlb;

import java.io.Serializable;

public class CodeResult implements Serializable {
    /**
     * code
     */
    private String code;
    /**
     * msg
     */
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
