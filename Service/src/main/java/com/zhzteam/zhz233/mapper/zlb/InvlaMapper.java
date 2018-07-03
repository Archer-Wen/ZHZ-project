package com.zhzteam.zhz233.mapper.zlb;

import com.zhzteam.zhz233.model.zlb.InvlaInfoResult;
import com.zhzteam.zhz233.model.zlb.InvlaResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InvlaMapper {
    /**
     * 返回 统计 信息
     * @param accountNo
     * @return
     */
    public List<InvlaResult> selectTByANO(@Param("accountNo") String accountNo);
    /**
     * 返回 资金 信息
     * @param accountNo
     * @return
     */
    public List<InvlaInfoResult> selectTByNO(@Param("accountNo") String accountNo);

    /**
     * 增加流水订单
     * @param order_no
     * @param account_no
     * @param order_operate_type
     * @param order_amount
     * @return
     */
    public Long insertTByKey(@Param("orderNo") String order_no,
                             @Param("accountNo") String account_no,
                             @Param("orderType") Integer order_operate_type,
                             @Param("amount") Double order_amount);
    /**
     * 获取自增 NO
     * @return
     */
    public String selectTByAuto();
}
