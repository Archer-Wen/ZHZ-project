package com.zhzteam.zhz233.mapper.zlb;

import com.zhzteam.zhz233.model.zlb.GoodsRentResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMoreMapper {
    /**
     * 返回 List<GoodsRentResult> Limit N
     * @param goodstype
     * @param goodsrecomm
     * @param goodsstatus
     * @param pagesize
     * @return
     */
    public List<GoodsRentResult> selectTByKey(
            @Param("goodstype") Integer goodstype,
            @Param("goodsrecomm") Integer goodsrecomm,
            @Param("goodsstatus") Integer goodsstatus,
            @Param("pagesize") Integer pagesize);
}
