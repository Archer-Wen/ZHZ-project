package com.zhzteam.zhz233.mapper.wlh;

import com.zhzteam.zhz233.model.GoodsRentModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @描述
 * @参数 $params
 * @返回值 $return
 * @创建人 wenliheng
 * @创建时间 2018/5/23
 */
@Mapper
public interface PCGoodsRentMapper {

    @Select("select * from tab_goods_rent where goods_no = #{goodsNo}")
    GoodsRentModel selectByGoodsNo(@Param("goodsNo") String goodsNo);
}
