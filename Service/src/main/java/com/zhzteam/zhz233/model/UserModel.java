package com.zhzteam.zhz233.model;

import java.io.Serializable;
import java.util.Date;

public class UserModel implements Serializable {
    private Long id;//自增id
    private String account_no;//user no 自增
    private String account;//账号
    private String cell_phone;//绑定号码
    private String password;//登录密码
    private Date update_time;//更新时间
    private Date create_time;//注册时间
    private Integer access;//登录允许//0：不允许 1：普通用户 2：管理员 3：超级管理员 4：商家账户

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Integer getAccess() {
        return access;
    }

    public void setAccess(Integer access) {
        this.access = access;
    }
}
