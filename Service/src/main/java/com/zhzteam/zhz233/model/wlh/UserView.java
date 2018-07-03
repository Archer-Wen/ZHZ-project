package com.zhzteam.zhz233.model.wlh;

/**
 * @描述
 * @参数 $params
 * @返回值 $return
 * @创建人 wenliheng
 * @创建时间 2018/5/22
 */
public class UserView {
    private String account_no;
    private String account;
    private String cell_phone;
    private Integer access;

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
}
