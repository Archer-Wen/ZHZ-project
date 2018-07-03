package com.zhzteam.zhz233.model.zlb;

import java.io.Serializable;

public class AccountResult implements Serializable {
    private String account;
    private String cellphone;
    private String imgUrl;
    private Integer certification;
    private Double available;
    private Double frozen;
    private Integer creditLevel;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getCertification() {
        return certification;
    }

    public void setCertification(Integer certification) {
        this.certification = certification;
    }

    public Double getAvailable() {
        return available;
    }

    public void setAvailable(Double available) {
        this.available = available;
    }

    public Double getFrozen() {
        return frozen;
    }

    public void setFrozen(Double frozen) {
        this.frozen = frozen;
    }

    public Integer getCreditLevel() {
        return creditLevel;
    }

    public void setCreditLevel(Integer creditLevel) {
        this.creditLevel = creditLevel;
    }
}
