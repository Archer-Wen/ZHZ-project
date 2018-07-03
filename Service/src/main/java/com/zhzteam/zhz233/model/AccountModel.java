package com.zhzteam.zhz233.model;

import java.util.Date;

/**
 * @描述
 * @参数 $params
 * @返回值 $return
 * @创建人 wenliheng
 * @创建时间 2018/5/24
 */
public class AccountModel {

    private int id;
    private String account_no;
    private int certification;
    private double available;
    private double frozen;
    private int credit_level;
    private String traders_password;
    private String traders_alipay;
    private String traders_wechat_pay;
    private Date update_time;
    private Date create_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount_no() {
        return account_no;
    }

    public void setAccount_no(String account_no) {
        this.account_no = account_no;
    }

    public int getCertification() {
        return certification;
    }

    public void setCertification(int certification) {
        this.certification = certification;
    }

    public double getAvailable() {
        return available;
    }

    public void setAvailable(double available) {
        this.available = available;
    }

    public double getFrozen() {
        return frozen;
    }

    public void setFrozen(double frozen) {
        this.frozen = frozen;
    }

    public int getCredit_level() {
        return credit_level;
    }

    public void setCredit_level(int credit_level) {
        this.credit_level = credit_level;
    }

    public String getTraders_password() {
        return traders_password;
    }

    public void setTraders_password(String traders_password) {
        this.traders_password = traders_password;
    }

    public String getTraders_alipay() {
        return traders_alipay;
    }

    public void setTraders_alipay(String traders_alipay) {
        this.traders_alipay = traders_alipay;
    }

    public String getTraders_wechat_pay() {
        return traders_wechat_pay;
    }

    public void setTraders_wechat_pay(String traders_wechat_pay) {
        this.traders_wechat_pay = traders_wechat_pay;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
