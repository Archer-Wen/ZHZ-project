package com.zhzteam.zhz233.service.zlb;

import com.zhzteam.zhz233.model.zlb.LeaseOrderInfo;
import com.zhzteam.zhz233.model.zlb.LeaseOrderResult;

import java.util.List;

public interface OrderService {
    /**
     * 返回 List<LeaseOrderResult> Limit N
     * @param pagesize
     * @return
     */
    public List<LeaseOrderResult> selectTByKey(Integer pagesize);
    /**
     * 获取自增 NO
     * @return
     */
    public String selectTByAuto();
    /**
     * 添加 订单 信息
     * @param leaseOrderInfo
     * @return
     */
    public Boolean insertTByKey(LeaseOrderInfo leaseOrderInfo);
}
