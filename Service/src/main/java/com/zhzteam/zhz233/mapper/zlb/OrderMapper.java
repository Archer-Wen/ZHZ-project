package com.zhzteam.zhz233.mapper.zlb;

import com.zhzteam.zhz233.model.zlb.LeaseOrderInfo;
import com.zhzteam.zhz233.model.zlb.LeaseOrderResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    /**
     * 返回 List<LeaseOrderResult> Limit N
     * @param pagesize
     * @return
     */
    public List<LeaseOrderResult> selectTByKey(@Param("pagesize") Integer pagesize);

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
    public Long insertTByKey(LeaseOrderInfo leaseOrderInfo);
}
