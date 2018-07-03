package com.zhzteam.zhz233.model.zlb;

import java.io.Serializable;

public class InvlaResult implements Serializable {
    private Integer type;
    private Integer number;
    private Double total;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
