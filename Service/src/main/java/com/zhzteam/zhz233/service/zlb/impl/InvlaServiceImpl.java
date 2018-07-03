package com.zhzteam.zhz233.service.zlb.impl;

import com.zhzteam.zhz233.mapper.zlb.InvlaMapper;
import com.zhzteam.zhz233.model.zlb.InvlaInfoResult;
import com.zhzteam.zhz233.model.zlb.InvlaResult;
import com.zhzteam.zhz233.service.zlb.InvlaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvlaServiceImpl implements InvlaService {
    @Autowired
    InvlaMapper invlaMapper;
    @Override
    public List<InvlaResult> selectTByANO(String accountNo) {
        return invlaMapper.selectTByANO(accountNo);
    }

    @Override
    public List<InvlaInfoResult> selectTByNO(String accountNo) {
        return invlaMapper.selectTByNO(accountNo);
    }

    @Override
    public Boolean insertTByKey(String order_no, String account_no, Integer order_operate_type, Double order_amount) {
        if(invlaMapper.insertTByKey(order_no, account_no, order_operate_type, order_amount) > 0) return true;
        return false;
    }

    @Override
    public String selectTByAuto() {
        return invlaMapper.selectTByAuto();
    }
}
