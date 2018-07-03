package com.zhzteam.zhz233.mapper.zlb;

import com.zhzteam.zhz233.model.zlb.GoodsRentMoreResult;
import com.zhzteam.zhz233.model.zlb.GoodsResult;
import com.zhzteam.zhz233.model.zlb.RentResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RentMapper {
    /**
     * 返回 商品信息 List<RentResult>
     * @param goodstype
     * @param goodsstatus
     * @param pagesize
     * @return
     */
    public List<RentResult> selectTByKey(@Param("goodstype") Integer goodstype,@Param("goodsstatus") Integer goodsstatus,@Param("pagesize") Integer pagesize);
    /**
     * 返回 List<RentResult> Limit N
     * @param gamesName
     * @param gamesServer
     * @param gamesArea
     * @param searchKey
     * @param priceRange
     * @param authenticate
     * @param goodsType
     * @param goodsSort
     * @return
     */
    public List<RentResult> selectTBySKey(
            @Param("gamesName") String gamesName,
            @Param("gamesServer") String gamesServer,
            @Param("gamesArea") String gamesArea,
            @Param("searchKey") String searchKey,
            @Param("priceRange") Integer priceRange,
            @Param("authenticate") Integer authenticate,
            @Param("goodsType") Integer goodsType,
            @Param("goodsSort") Integer goodsSort,
            @Param("goodsStatus") Integer goodsStatus,
            @Param("currentPage") Integer currentPage,
            @Param("pageSize") Integer pageSize
    );

    /**
     * 返回 Interger N
     * @param gamesName
     * @param gamesServer
     * @param gamesArea
     * @param searchKey
     * @param priceRange
     * @param authenticate
     * @param goodsType
     * @param goodsSort
     * @param goodsStatus
     * @return
     */
    public Integer selectTBySAutoCount(
            @Param("gamesName") String gamesName,
            @Param("gamesServer") String gamesServer,
            @Param("gamesArea") String gamesArea,
            @Param("searchKey") String searchKey,
            @Param("priceRange") Integer priceRange,
            @Param("authenticate") Integer authenticate,
            @Param("goodsType") Integer goodsType,
            @Param("goodsSort") Integer goodsSort,
            @Param("goodsStatus") Integer goodsStatus
    );
    /**
     * 获取商品信息 By No
     * @param goodsNo
     * @return
     */
    public GoodsRentMoreResult selectTByGoodsNo(@Param("goodsNo") String goodsNo);
}
