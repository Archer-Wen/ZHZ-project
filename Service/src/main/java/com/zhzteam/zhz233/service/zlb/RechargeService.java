package com.zhzteam.zhz233.service.zlb;

public interface RechargeService {
    /**
     * 增加流水订单
     * @param orderNo
     * @param accountNo
     * @param orderMethod
     * @param amount
     * @param status
     * @return
     */
    public Boolean insertTByKey(String orderNo,String accountNo,Integer orderMethod,
                             Double amount,Integer status);//2
    /**
     * 获取自增 NO
     * @return
     */
    public String selectTByAuto();
}
