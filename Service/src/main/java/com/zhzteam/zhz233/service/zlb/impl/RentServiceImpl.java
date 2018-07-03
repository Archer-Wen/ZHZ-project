package com.zhzteam.zhz233.service.zlb.impl;

import com.zhzteam.zhz233.mapper.zlb.RentMapper;
import com.zhzteam.zhz233.model.zlb.GoodsRentMoreResult;
import com.zhzteam.zhz233.model.zlb.RentResult;
import com.zhzteam.zhz233.service.zlb.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentServiceImpl implements RentService {
    @Autowired
    RentMapper rentMapper;

    @Override
    public List<RentResult> selectTByKey(Integer goodstype, Integer goodsstatus, Integer pagesize) {
        return rentMapper.selectTByKey(goodstype, goodsstatus, pagesize);
    }

    @Override
    public List<RentResult> selectTBySKey(String gamesName, String gamesServer, String gamesArea, String searchKey, Integer priceRange, Integer authenticate, Integer goodsType, Integer goodsSort, Integer goodsStatus, Integer currentPage, Integer pageSize) {
        return rentMapper.selectTBySKey(gamesName, gamesServer, gamesArea, searchKey, priceRange, authenticate, goodsType, goodsSort, goodsStatus, currentPage, pageSize);
    }

    @Override
    public Integer selectTBySAutoCount(String gamesName, String gamesServer, String gamesArea, String searchKey, Integer priceRange, Integer authenticate, Integer goodsType, Integer goodsSort, Integer goodsStatus) {
        return rentMapper.selectTBySAutoCount(gamesName, gamesServer, gamesArea, searchKey, priceRange, authenticate, goodsType, goodsSort, goodsStatus);
    }

    @Override
    public GoodsRentMoreResult selectTByGoodsNo(String goodsNo) {
        return rentMapper.selectTByGoodsNo(goodsNo);
    }
}
