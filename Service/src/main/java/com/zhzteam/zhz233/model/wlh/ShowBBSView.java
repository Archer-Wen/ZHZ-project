package com.zhzteam.zhz233.model.wlh;

import java.time.LocalDateTime;

/**
 * @描述
 * @参数 $params
 * @返回值 $return
 * @创建人 wenliheng
 * @创建时间 2018/5/23
 */
public class ShowBBSView {
    private Integer bbs_id;
    private String account;
    private String bbs_title;
    private LocalDateTime createtime;
    private String board_name;
    private String bbs_count;

    public String getBbs_count() {
        return bbs_count;
    }

    public void setBbs_count(String bbs_count) {
        this.bbs_count = bbs_count;
    }

    public Integer getBbs_id() {
        return bbs_id;
    }

    public void setBbs_id(Integer bbs_id) {
        this.bbs_id = bbs_id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getBbs_title() {
        return bbs_title;
    }

    public void setBbs_title(String bbs_title) {
        this.bbs_title = bbs_title;
    }

    public LocalDateTime getCreatetime() {
        return createtime;
    }

    public void setCreatetime(LocalDateTime createtime) {
        this.createtime = createtime;
    }

    public String getBoard_name() {
        return board_name;
    }

    public void setBoard_name(String board_name) {
        this.board_name = board_name;
    }
}
