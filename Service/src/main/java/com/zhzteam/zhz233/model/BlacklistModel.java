package com.zhzteam.zhz233.model;

import java.io.Serializable;
import java.util.Date;

public class BlacklistModel implements Serializable {
    private Long id;
    private String blacklist_no;//编号
    private String account_no;//执行 拉黑账号
    private String link_account_no;//关联 账号
    private String blacklist_reasons;//原因
    private Date update_time;
    private Date create_time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBlacklist_no() {
        return blacklist_no;
    }

    public void setBlacklist_no(String blacklist_no) {
        this.blacklist_no = blacklist_no;
    }

    public String getAccount_no() {
        return account_no;
    }

    public void setAccount_no(String account_no) {
        this.account_no = account_no;
    }

    public String getLink_account_no() {
        return link_account_no;
    }

    public void setLink_account_no(String link_account_no) {
        this.link_account_no = link_account_no;
    }

    public String getBlacklist_reasons() {
        return blacklist_reasons;
    }

    public void setBlacklist_reasons(String blacklist_reasons) {
        this.blacklist_reasons = blacklist_reasons;
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
