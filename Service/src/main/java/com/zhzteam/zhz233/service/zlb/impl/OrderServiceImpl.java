package com.zhzteam.zhz233.service.zlb.impl;

import com.zhzteam.zhz233.mapper.zlb.OrderMapper;
import com.zhzteam.zhz233.model.zlb.LeaseOrderInfo;
import com.zhzteam.zhz233.model.zlb.LeaseOrderResult;
import com.zhzteam.zhz233.service.zlb.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<LeaseOrderResult> selectTByKey(Integer pagesize) {
        return orderMapper.selectTByKey(pagesize);
    }

    @Override
    public String selectTByAuto() {
        return orderMapper.selectTByAuto();
    }

    @Override
    public Boolean insertTByKey(LeaseOrderInfo leaseOrderInfo) {
        if(orderMapper.insertTByKey(leaseOrderInfo) > 0) return true;
        else return false;
    }
}
