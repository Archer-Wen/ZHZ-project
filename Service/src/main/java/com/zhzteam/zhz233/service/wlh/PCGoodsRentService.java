package com.zhzteam.zhz233.service.wlh;

import com.zhzteam.zhz233.model.GoodsRentModel;

/**
 * @描述
 * @参数 $params
 * @返回值 $return
 * @创建人 wenliheng
 * @创建时间 2018/5/24
 */
public interface PCGoodsRentService {
    GoodsRentModel selectByGoodsNo(String goodsNo);
}
