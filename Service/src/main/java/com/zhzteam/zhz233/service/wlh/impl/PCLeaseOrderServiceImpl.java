package com.zhzteam.zhz233.service.wlh.impl;

import com.zhzteam.zhz233.mapper.wlh.PCLeaseOrderMapper;
import com.zhzteam.zhz233.model.LeaseOrderModel;
import com.zhzteam.zhz233.model.wlh.UserRentOrderView;
import com.zhzteam.zhz233.service.wlh.PCLeaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @描述
 * @参数 $params
 * @返回值 $return
 * @创建人 wenliheng
 * @创建时间 2018/5/23
 */
@Service
public class PCLeaseOrderServiceImpl implements PCLeaseOrderService {
    @Autowired
    PCLeaseOrderMapper pcLeaseOrderMapper;

    @Override
    public List<UserRentOrderView> showBuyerOrder(String buyerNo,Integer state) {
        if (StringUtils.isEmpty(buyerNo) || state==null){
            return null;
        }
        List<UserRentOrderView> list = pcLeaseOrderMapper.selectByBuyer(buyerNo,state);
        return list;
    }

    @Override
    public LeaseOrderModel findOne(String orderNo) {
        if (StringUtils.isEmpty(orderNo)){
            return null;
        }
        LeaseOrderModel leaseOrderPojo = pcLeaseOrderMapper.selectByOrderNo(orderNo);
        return leaseOrderPojo;
    }
}
