package com.zhzteam.zhz233.mapper.wlh;

import com.zhzteam.zhz233.model.LeaseOrderModel;
import com.zhzteam.zhz233.model.wlh.UserRentOrderView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @描述
 * @参数 $params
 * @返回值 $return
 * @创建人 wenliheng
 * @创建时间 2018/5/23
 */
@Mapper
public interface PCLeaseOrderMapper {
    @Select("select tlo.order_no,tgr.goods_game,tgr.goods_access,tlo.order_amount,tlo.order_end_time \n"+
            "from tab_lease_order tlo\n" +
            "left join tab_goods_rent tgr on tlo.goods_no = tgr.goods_no\n" +
            "where tlo.buyer_no = #{buyerNo} and tlo.order_state = #{state}")
    List<UserRentOrderView> selectByBuyer(@Param("buyerNo") String buyerNo,@Param("state")Integer state);

    @Select("select * from tab_lease_order where order_no = #{orderNo}")
    LeaseOrderModel selectByOrderNo(@Param("orderNo")String orderNo);
}
