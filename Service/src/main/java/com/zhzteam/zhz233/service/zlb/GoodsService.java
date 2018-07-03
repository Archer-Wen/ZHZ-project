package com.zhzteam.zhz233.service.zlb;

import com.zhzteam.zhz233.model.zlb.GoodsLeaseResult;
import com.zhzteam.zhz233.model.zlb.GoodsRentMoreResult;
import com.zhzteam.zhz233.model.zlb.GoodsResult;

import java.util.List;

public interface GoodsService {
    /**
     * 返回 List<GoodsResult> Limit N
     * @param pagesize
     * @return
     */
    public List<GoodsResult> selectTByKey(Integer goodstype, Integer goodsrecomm, Integer goodsstatus, Integer pagesize);
    /**
     * 返回租号商品 总数
     * @param goodsstatus
     * @return
     */
    public Integer selectRentTotal(Integer goodstype, Integer goodsstatus);

    /**
     * selectByGoodsNo 返回 Count(id)
     * @param goodsNo
     * @param goodsType
     * @param goodsStatus
     * @return
     */
    public Boolean selectByGoodsNo(String goodsNo,Integer goodsType, Integer goodsStatus);
    /**
     * 获取 商品 信息 selectTByGoodsNo
     * @param goodsNo
     * @return
     */
    public GoodsLeaseResult selectTByGoodsNo(String goodsNo);
}
