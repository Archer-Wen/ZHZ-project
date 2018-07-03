package com.zhzteam.zhz233.mapper.zlb;

import org.apache.ibatis.annotations.Param;

public interface RechargeMapper {
    /**
     * 增加流水订单
     * @param orderNo
     * @param accountNo
     * @param orderMethod
     * @param amount
     * @param status
     * @return
     */
    public Long insertTByKey(@Param("orderNo") String orderNo,
                             @Param("accountNo") String accountNo,
                             @Param("orderMethod") Integer orderMethod,
                             @Param("amount") Double amount,
                             @Param("status") Integer status);//2
    /**
     * 获取自增 NO
     * @return
     */
    public String selectTByAuto();
}
