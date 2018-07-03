package com.zhzteam.zhz233.model.zlb;

import java.io.Serializable;

public class SMSResult implements Serializable {
    /**
     * 状态码respCode
     */
    private String respCode;
    /**
     * 描述respDesc
     */
    private String respDesc;
    /**
     * 错误条数
     */
    private String failCount;
    /**
     * 返回ID
     */
    private String smsId;

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespDesc() {
        return respDesc;
    }

    public void setRespDesc(String respDesc) {
        this.respDesc = respDesc;
    }

    public String getFailCount() {
        return failCount;
    }

    public void setFailCount(String failCount) {
        this.failCount = failCount;
    }

    public String getSmsId() {
        return smsId;
    }

    public void setSmsId(String smsId) {
        this.smsId = smsId;
    }
}
