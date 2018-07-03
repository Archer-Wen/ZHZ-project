package com.zhzteam.zhz233.service.wlh.impl;

import com.zhzteam.zhz233.mapper.wlh.PCGoodsRentMapper;
import com.zhzteam.zhz233.model.GoodsRentModel;
import com.zhzteam.zhz233.service.wlh.PCGoodsRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @描述
 * @参数 $params
 * @返回值 $return
 * @创建人 wenliheng
 * @创建时间 2018/5/24
 */
@Service
public class PCGoodsRentServiceImpl implements PCGoodsRentService {

    @Autowired
    PCGoodsRentMapper goodsRentMapper;
    @Override
    public GoodsRentModel selectByGoodsNo(String goodsNo) {
        if (StringUtils.isEmpty(goodsNo)) {
            return null;
        }
        GoodsRentModel goodsRentPojo = goodsRentMapper.selectByGoodsNo(goodsNo);
        return goodsRentPojo;
    }
}
