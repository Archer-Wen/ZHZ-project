package com.zhzteam.zhz233.model.zlb;

import java.io.Serializable;
import java.util.Date;

public class NoticeResult implements Serializable {
    private String notice_no;//编号
    private Integer notice_type;//类型
    private String notice_theme;//主题
    private String notice_content;//内容
    private Date create_time;//创建时间
    private Long notice_viewcount;//累计访问量

    public String getNotice_no() {
        return notice_no;
    }

    public void setNotice_no(String notice_no) {
        this.notice_no = notice_no;
    }

    public Integer getNotice_type() {
        return notice_type;
    }

    public void setNotice_type(Integer notice_type) {
        this.notice_type = notice_type;
    }

    public String getNotice_theme() {
        return notice_theme;
    }

    public void setNotice_theme(String notice_theme) {
        this.notice_theme = notice_theme;
    }

    public String getNotice_content() {
        return notice_content;
    }

    public void setNotice_content(String notice_content) {
        this.notice_content = notice_content;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Long getNotice_viewcount() {
        return notice_viewcount;
    }

    public void setNotice_viewcount(Long notice_viewcount) {
        this.notice_viewcount = notice_viewcount;
    }
}
