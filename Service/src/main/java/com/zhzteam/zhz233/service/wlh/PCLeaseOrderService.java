package com.zhzteam.zhz233.service.wlh;

import com.zhzteam.zhz233.model.LeaseOrderModel;
import com.zhzteam.zhz233.model.wlh.UserRentOrderView;

import java.util.List;

/**
 * @描述
 * @参数 $params
 * @返回值 $return
 * @创建人 wenliheng
 * @创建时间 2018/5/23
 */
public interface PCLeaseOrderService {

    public List<UserRentOrderView> showBuyerOrder(String buyerNo,Integer state);

    public LeaseOrderModel findOne(String orderNo);
}
