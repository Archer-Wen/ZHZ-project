package com.zhzteam.zhz233.service.zlb;

import com.zhzteam.zhz233.model.zlb.InvlaInfoResult;
import com.zhzteam.zhz233.model.zlb.InvlaResult;

import java.util.List;

public interface InvlaService {
    /**
     * 返回 统计 信息
     * @param accountNo
     * @return
     */
    public List<InvlaResult> selectTByANO(String accountNo);

    /**
     * 返回 资金 信息
     * @param accountNo
     * @return
     */
    public List<InvlaInfoResult> selectTByNO(String accountNo);
    /**
     * 增加流水订单
     * @param order_no
     * @param account_no
     * @param order_operate_type
     * @param order_amount
     * @return
     */
    public Boolean insertTByKey(String order_no,String account_no,
                                Integer order_operate_type,Double order_amount);
    /**
     * 获取自增 NO
     * @return
     */
    public String selectTByAuto();
}
