package com.zhzteam.zhz233.model.zlb;

import java.io.Serializable;

public class UserResult implements Serializable {
    private String account_no;//编号
    private String account;//账号
    private String cell_phone;//绑定号码
    private Integer access;//登录允许//0：不允许 1：普通用户 2：会员用户 3：管理员 4：超级管理员 5：商家账户
    private  String img_url;//用户IMG_URL

    public String getAccount_no() {
        return account_no;
    }

    public void setAccount_no(String account_no) {
        this.account_no = account_no;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCell_phone() {
        return cell_phone;
    }

    public void setCell_phone(String cell_phone) {
        this.cell_phone = cell_phone;
    }

    public Integer getAccess() {
        return access;
    }

    public void setAccess(Integer access) {
        this.access = access;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}
