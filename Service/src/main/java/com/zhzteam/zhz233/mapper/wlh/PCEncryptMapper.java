package com.zhzteam.zhz233.mapper.wlh;

import com.zhzteam.zhz233.model.wlh.ShowPcOrderView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @描述
 * @参数 $params
 * @返回值 $return
 * @创建人 wenliheng
 * @创建时间 2018/5/27
 */
@Mapper
public interface PCEncryptMapper {

    @Select("SELECT\n" +
            "\tg.goods_theme,\n" +
            "\tlo.order_no,\n" +
            "\tlo.buyer_no,\n" +
            "\tlo.order_start_time,\n" +
            "\tlo.order_end_time,\n" +
            "\tgm.game_name,\n" +
            "\tgm.goods_area,\n" +
            "\tgm.goods_server,\n" +
            "\tgr.goods_access\n" +
            "FROM\n" +
            "\ttab_lease_order lo\n" +
            "\tLEFT JOIN tab_goods g ON lo.goods_no = g.goods_no\n" +
            "\tLEFT JOIN tab_goods_more gm ON lo.goods_no = gm.goods_no \n" +
            "\tLEFT JOIN tab_goods_rent gr ON lo.goods_no = gr.goods_no\n" +
            "\tWHERE\n" +
            "\tlo.order_no = #{orderNo}")
    ShowPcOrderView findOrderInfo(@Param("orderNo")String orderNo);
}
