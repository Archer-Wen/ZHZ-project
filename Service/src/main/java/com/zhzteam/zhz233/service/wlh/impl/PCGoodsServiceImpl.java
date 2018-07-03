package com.zhzteam.zhz233.service.wlh.impl;

import com.zhzteam.zhz233.mapper.wlh.PCGoodsMapper;
import com.zhzteam.zhz233.mapper.wlh.PCGoodsRentMapper;
import com.zhzteam.zhz233.model.GoodsModel;
import com.zhzteam.zhz233.model.GoodsRentModel;
import com.zhzteam.zhz233.model.wlh.ShowRentView;
import com.zhzteam.zhz233.service.wlh.PCGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @描述
 * @参数 $params
 * @返回值 $return
 * @创建人 wenliheng
 * @创建时间 2018/5/23
 */
@Service
public class PCGoodsServiceImpl implements PCGoodsService {
    @Autowired
    PCGoodsMapper goodsMapper;
    @Autowired
    PCGoodsRentMapper goodsRentMapper;

    @Override
    public List<ShowRentView> showRent(String gameName) {
        List<GoodsModel> goodsPojo = goodsMapper.selectShowAll(1,1);
        List<ShowRentView> showRentViews = new ArrayList<>();
        for (GoodsModel g:goodsPojo){
            ShowRentView showRentView = new ShowRentView();
            GoodsRentModel goodsRentPojo = goodsRentMapper.selectByGoodsNo(g.getGoods_no());
            if(g.getGoods_game().equals(gameName) || gameName.equals("ALL")) {
                showRentView.setGoods_compensate(goodsRentPojo.getGoods_compensate());
                showRentView.setGoods_credit_level(goodsRentPojo.getGoods_credit_level());
                showRentView.setGoods_hour(goodsRentPojo.getGoods_hour());
                showRentView.setGoods_no(g.getGoods_no());
                showRentView.setGoods_recomm(g.getGoods_recomm());
                showRentView.setGoods_short_time(goodsRentPojo.getGoods_short_time());
                showRentView.setGoods_theme(g.getGoods_theme());
                showRentViews.add(showRentView);
            }
        }
        return showRentViews;
    }
}
