package com.zhzteam.zhz233.service.zlb.impl;

import com.zhzteam.zhz233.mapper.zlb.RechargeMapper;
import com.zhzteam.zhz233.service.zlb.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RechargeServiceImpl implements RechargeService {
    @Autowired
    RechargeMapper rechargeMapper;

    @Override
    public Boolean insertTByKey(String orderNo, String accountNo, Integer orderMethod, Double amount, Integer status) {
        if(rechargeMapper.insertTByKey(orderNo, accountNo, orderMethod, amount, status)>0) return true;
        else return false;
    }

    @Override
    public String selectTByAuto() {
        return rechargeMapper.selectTByAuto();
    }
}
