package com.zhzteam.zhz233.service.wlh.impl;

import com.zhzteam.zhz233.mapper.wlh.PCEncryptMapper;
import com.zhzteam.zhz233.model.wlh.ShowPcOrderView;
import com.zhzteam.zhz233.service.wlh.PCEncryptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @描述
 * @参数 $params
 * @返回值 $return
 * @创建人 wenliheng
 * @创建时间 2018/5/27
 */
@Service
public class PCEncryptServiceImpl implements PCEncryptService {

    @Autowired
    PCEncryptMapper encryptMapper;

    @Override
    public ShowPcOrderView findOrderInfo(String orderNo) {
        if (StringUtils.isEmpty(orderNo)){
            return null;
        }
        ShowPcOrderView orderView = encryptMapper.findOrderInfo(orderNo);
        return orderView;
    }
}
