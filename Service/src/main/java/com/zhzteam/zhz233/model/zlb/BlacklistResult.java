package com.zhzteam.zhz233.model.zlb;

import java.io.Serializable;
import java.util.Date;

public class BlacklistResult implements Serializable {
    private String blacklist_no;//编号
    private String link_account;//关联 账号
    private String blacklist_reasons;//原因
    private Date create_time;

    public String getBlacklist_no() {
        return blacklist_no;
    }

    public void setBlacklist_no(String blacklist_no) {
        this.blacklist_no = blacklist_no;
    }

    public String getLink_account() {
        return link_account;
    }

    public void setLink_account(String link_account) {
        this.link_account = link_account;
    }

    public String getBlacklist_reasons() {
        return blacklist_reasons;
    }

    public void setBlacklist_reasons(String blacklist_reasons) {
        this.blacklist_reasons = blacklist_reasons;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
