package com.zhzteam.zhz233.controller.zlb;

import com.zhzteam.zhz233.common.config.StatusConfig;
import com.zhzteam.zhz233.model.zlb.GamesResult;
import com.zhzteam.zhz233.model.zlb.GoodsResult;
import com.zhzteam.zhz233.model.zlb.ResultView;
import com.zhzteam.zhz233.service.zlb.impl.GamesServiceImpl;
import com.zhzteam.zhz233.service.zlb.impl.GoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/zlb")
public class TasteController {
    @Autowired
    GoodsServiceImpl goodsServiceImpl;
    @Autowired
    GamesServiceImpl gamesServiceImpl;

    private ResultView resultView;
    private List<GoodsResult> goodsResultList;
    private List<GamesResult> gamesResultList;

    private Map<String,Object> reMap;

    @RequestMapping(value = "/getTasteAutoInfo")
    public ResultView getTasteAutoInfo(){
        //初始化 容器
        resultView = new ResultView();
        gamesResultList = new ArrayList<GamesResult>();
        goodsResultList = new ArrayList<GoodsResult>();
        reMap = new HashMap<String, Object>();

        //放置 特价体验 游戏信息 热游
        gamesResultList = gamesServiceImpl.selectTByHotKey(8);
        reMap.put("HOTgamesResultList",gamesResultList);
        //放置 特价体验 游戏信息 端游
        gamesResultList = gamesServiceImpl.selectTByKey(1,8);
        reMap.put("DYgamesResultList",gamesResultList);
        //放置 特价体验 游戏信息 页游
        gamesResultList = gamesServiceImpl.selectTByKey(2,8);
        reMap.put("YYgamesResultList",gamesResultList);
        //放置 特价体验 游戏信息 手游
        gamesResultList = gamesServiceImpl.selectTByKey(3,8);
        reMap.put("SYgamesResultList",gamesResultList);
        //放置 特价体验 商品信息
        goodsResultList = goodsServiceImpl.selectTByKey(1,3,1,10);
        reMap.put("goodsResultList",goodsResultList);
        if(!reMap.isEmpty()){
            resultView.setReMap(reMap);
            resultView.setStatus(StatusConfig.SUCCESS);
            resultView.setMessage("获取体验商品信息成功！");
        }else{
            resultView.setStatus(StatusConfig.FAIL);
            resultView.setMessage("获取体验商品信息失败！");
        }
        return resultView;
    }
}
