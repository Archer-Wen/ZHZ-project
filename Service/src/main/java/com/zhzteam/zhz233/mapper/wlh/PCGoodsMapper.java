package com.zhzteam.zhz233.mapper.wlh;

import com.zhzteam.zhz233.model.GoodsModel;
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
public interface PCGoodsMapper {
    @Select("select * from tab_goods")
    GoodsModel selectAll();

    /**
     * 用于展示表格商品搜索
     * @param goods_type 商品类型（0/测试商品 1/出租商品 2/买卖商品 3/代练商品 4/其他商品）
     * @param goods_status 商品状态( 0 审核中/ 1已审核/ 2审核不通过/ 3已出租/ 4已预约/ 5已下架)
     * @return
     */
    @Select("select * from tab_goods where goods_type = #{goodsType} and goods_status = #{goodsStatus}")
    List<GoodsModel> selectShowAll(@Param("goodsType") Integer goods_type, @Param("goodsStatus")Integer goods_status);
}
