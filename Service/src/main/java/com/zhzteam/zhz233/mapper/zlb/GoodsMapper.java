package com.zhzteam.zhz233.mapper.zlb;

import com.zhzteam.zhz233.model.zlb.GoodsLeaseResult;
import com.zhzteam.zhz233.model.zlb.GoodsRentMoreResult;
import com.zhzteam.zhz233.model.zlb.GoodsResult;
import com.zhzteam.zhz233.model.zlb.LeaseOrderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {
    /**
     * 返回 List<GoodsResult> Limit N
     * @param goodstype
     * @param goodsrecomm
     * @param goodsstatus
     * @param pagesize
     * @return
     */
    public List<GoodsResult> selectTByKey(@Param("goodstype") Integer goodstype, @Param("goodsrecomm") Integer goodsrecomm, @Param("goodsstatus") Integer goodsstatus, @Param("pagesize") Integer pagesize);

    /**
     * 返回商品 总数
     * @param goodsstatus
     * @return
     */
    public Integer selectRentTotal(@Param("goodstype")Integer goodstype, @Param("goodsstatus") Integer goodsstatus);

    /**
     * selectByGoodsNo 返回 Count(id)
     * @param goodsNo
     * @param goodsType
     * @param goodsStatus
     * @return
     */
    public Integer selectByGoodsNo(@Param("goodsNo") String goodsNo,@Param("goodsType")Integer goodsType, @Param("goodsStatus") Integer goodsStatus);

    /**
     * 获取 商品 信息 selectTByGoodsNo
     * @param goodsNo
     * @return
     */
    public GoodsLeaseResult selectTByGoodsNo(@Param("goodsNo") String goodsNo);

}
