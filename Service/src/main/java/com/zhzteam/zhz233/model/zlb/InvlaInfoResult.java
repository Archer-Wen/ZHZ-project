package com.zhzteam.zhz233.model.zlb;

import java.io.Serializable;
import java.util.Date;

public class InvlaInfoResult implements Serializable {
    private String order_no;
    private String order_operate_type;
    private String order_amount;
    private Date create_time;

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getOrder_operate_type() {
        return order_operate_type;
    }

    public void setOrder_operate_type(String order_operate_type) {
        this.order_operate_type = order_operate_type;
    }

    public String getOrder_amount() {
        return order_amount;
    }

    public void setOrder_amount(String order_amount) {
        this.order_amount = order_amount;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
