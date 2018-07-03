package com.zhzteam.zhz233.model;

import java.time.LocalDateTime;

/**
 * @描述
 * @参数 $params
 * @返回值 $return
 * @创建人 wenliheng
 * @创建时间 2018/5/23
 */
public class BBSModel {

    private Integer bbs_id;
    private String account_no;
    private String bbs_title;
    private String bbs_count;
    private Integer board_id;
    private LocalDateTime createtime;
    private LocalDateTime updatetime;

    public Integer getBbs_id() {
        return bbs_id;
    }

    public void setBbs_id(Integer bbs_id) {
        this.bbs_id = bbs_id;
    }

    public String getAccount_no() {
        return account_no;
    }

    public void setAccount_no(String account_no) {
        this.account_no = account_no;
    }

    public String getBbs_title() {
        return bbs_title;
    }

    public void setBbs_title(String bbs_title) {
        this.bbs_title = bbs_title;
    }

    public String getBbs_count() {
        return bbs_count;
    }

    public void setBbs_count(String bbs_count) {
        this.bbs_count = bbs_count;
    }

    public Integer getBoard_id() {
        return board_id;
    }

    public void setBoard_id(Integer board_id) {
        this.board_id = board_id;
    }

    public LocalDateTime getCreatetime() {
        return createtime;
    }

    public void setCreatetime(LocalDateTime createtime) {
        this.createtime = createtime;
    }

    public LocalDateTime getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(LocalDateTime updatetime) {
        this.updatetime = updatetime;
    }
}
