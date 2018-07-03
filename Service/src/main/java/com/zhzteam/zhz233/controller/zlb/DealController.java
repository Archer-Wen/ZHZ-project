package com.zhzteam.zhz233.controller.zlb;

import com.zhzteam.zhz233.common.config.StatusConfig;
import com.zhzteam.zhz233.model.zlb.*;
import com.zhzteam.zhz233.service.zlb.impl.GamesServiceImpl;
import com.zhzteam.zhz233.service.zlb.impl.GoodsServiceImpl;
import com.zhzteam.zhz233.service.zlb.impl.RentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/zlb")
public class DealController {
    @Autowired
    GamesServiceImpl gamesServiceImpl;
    @Autowired
    RentServiceImpl rentServiceImpl;
    @Autowired
    GoodsServiceImpl goodsServiceImpl;

    private ResultView resultView;
    private GoodsPageResult goodsPageResult;
    private GoodsRentMoreResult goodsRentMoreResult;

    private List<GamesResult> gamesResultList;
    private List<RentResult> rentResultList;
    private List<String> stringList;

    private Map<String,Object> reMap;

    @RequestMapping(value = "/getGoodsShowInfo")
    public ResultView getGoodsShowInfo(@RequestParam("GoodsNo") String GoodsNo){
        resultView = new ResultView();
        goodsRentMoreResult = new GoodsRentMoreResult();
        reMap = new HashMap<String, Object>();
        if(GoodsNo != null){
            goodsRentMoreResult = rentServiceImpl.selectTByGoodsNo(GoodsNo);
            if(goodsRentMoreResult != null){
                reMap.put("goodsDetailInfo",goodsRentMoreResult);
                resultView.setReMap(reMap);
                resultView.setStatus(StatusConfig.SUCCESS);
                resultView.setMessage("获取商品信息成功！");
            }else{
                resultView.setStatus(StatusConfig.FAIL);
                resultView.setMessage("获取数据信息错误！");
            }
        }else {
            resultView.setStatus(StatusConfig.FAIL);
            resultView.setMessage("获取商品信息错误！");
        }
        return resultView;
    }

    @RequestMapping(value = "/getGamesArea")
    public ResultView getGamesArea(@RequestParam("gamesName") String gamesName, @RequestParam("serverName") String serverName){
        resultView = new ResultView();
        stringList = new ArrayList<String>();
        reMap = new HashMap<String, Object>();
        if(gamesName != null){
            stringList = gamesServiceImpl.selectTByListArea(gamesName,serverName);
            reMap.put("areaStringList",stringList);
        }
        //放置 交易页面
        if(!reMap.isEmpty()){
            resultView.setReMap(reMap);
            resultView.setStatus(StatusConfig.SUCCESS);
            resultView.setMessage("获取游戏大区信息成功！");
        }else{
            resultView.setStatus(StatusConfig.FAIL);
            resultView.setMessage("获取游戏大区信息失败！");
        }
        return resultView;
    }

    @RequestMapping(value = "/getGamesServer")
    public ResultView getGamesServer(@RequestParam("gamesName") String gamesName){
        resultView = new ResultView();
        stringList = new ArrayList<String>();
        reMap = new HashMap<String, Object>();
        if(gamesName != null){
            stringList = gamesServiceImpl.selectTByListServer(gamesName);
            reMap.put("serverStringList",stringList);
        }
        //放置 交易页面
        if(!reMap.isEmpty()){
            resultView.setReMap(reMap);
            resultView.setStatus(StatusConfig.SUCCESS);
            resultView.setMessage("获取游戏服务器信息成功！");
        }else{
            resultView.setStatus(StatusConfig.FAIL);
            resultView.setMessage("获取游戏服务器信息失败！");
        }
        return resultView;
    }

    @RequestMapping(value = "/getDealAutoInfo")
    public ResultView getDealAutoInfo(HttpServletRequest hsRequest){
        //初始化容器
        resultView = new ResultView();
        goodsPageResult = new GoodsPageResult();
        rentResultList = new ArrayList<RentResult>();
        gamesResultList = new ArrayList<GamesResult>();
        stringList = new ArrayList<String>();
        reMap = new HashMap<String, Object>();

        //放置 交易页面 游戏信息 热游
        gamesResultList = gamesServiceImpl.selectTByHotKey(16);
        reMap.put("HOTgamesResultList",gamesResultList);
        //search_game
        stringList = gamesServiceImpl.selectTByListName(8);
        reMap.put("gamesStringList",stringList);
        //search_server

        //search_area

        //放置 交易页面 出租 商品信息
        //获取所有出租商品信息总数
        Integer totalCount = goodsServiceImpl.selectRentTotal(1,1);
        Integer totalPage = (totalCount % 16 == 0) ? (totalCount / 16) : (totalCount / 16 + 1);
        //默认出租商品信息展示
        rentResultList = rentServiceImpl.selectTByKey(1,1,16);
        goodsPageResult.setTotalCount(totalCount);
        goodsPageResult.setTotalPage(totalPage);
        goodsPageResult.setCurrentPage(1);
        goodsPageResult.setPageSize(rentResultList.size());
        //默认显示 分页信息
        reMap.put("rentResultList",rentResultList);
        reMap.put("goodsPageResult",goodsPageResult);
        //放置 交易页面
        if(!reMap.isEmpty()){
            resultView.setReMap(reMap);
            resultView.setStatus(StatusConfig.SUCCESS);
            resultView.setMessage("获取交易商品信息成功！");
        }else{
            resultView.setStatus(StatusConfig.FAIL);
            resultView.setMessage("获取交易商品信息失败！");
        }
        return resultView;
    }

    @RequestMapping(value = "/getDealSearchInfo")
    public ResultView getDealSearchInfo(HttpServletRequest hsRequest,@RequestBody SearchGoodsInfo searchGoodsInfo) {
        //初始化容器
        resultView = new ResultView();
        goodsPageResult = new GoodsPageResult();
        rentResultList = new ArrayList<RentResult>();
        gamesResultList = new ArrayList<GamesResult>();
        reMap = new HashMap<String, Object>();
        //获取所有商品信息总数
        Integer totalCount = rentServiceImpl.selectTBySAutoCount(
                searchGoodsInfo.getGamesName(),
                searchGoodsInfo.getGamesServer(),
                searchGoodsInfo.getGamesArea(),
                searchGoodsInfo.getSearchKey(),
                searchGoodsInfo.getPriceRange(),
                searchGoodsInfo.getAuthenticate(),
                searchGoodsInfo.getGoodsType(),
                searchGoodsInfo.getGoodsSort(),
                1
        );
        Integer totalPage = (totalCount % 16 == 0) ? (totalCount / 16) : (totalCount / 16 + 1);
        Integer pageSize = (totalCount>16)? 16: totalCount;
        goodsPageResult.setTotalCount(totalCount);
        goodsPageResult.setTotalPage(totalPage);
        goodsPageResult.setCurrentPage(searchGoodsInfo.getCurrentPage() + 1);
        goodsPageResult.setPageSize(pageSize);
        reMap.put("goodsPageResult",goodsPageResult);
        //放置 交易页面 商品信息
        //商品信息展示
        rentResultList = rentServiceImpl.selectTBySKey(
                searchGoodsInfo.getGamesName(),
                searchGoodsInfo.getGamesServer(),
                searchGoodsInfo.getGamesArea(),
                searchGoodsInfo.getSearchKey(),
                searchGoodsInfo.getPriceRange(),
                searchGoodsInfo.getAuthenticate(),
                searchGoodsInfo.getGoodsType(),
                searchGoodsInfo.getGoodsSort(),
                1,
                searchGoodsInfo.getCurrentPage(),
                16
        );
        //默认显示 分页信息
        reMap.put("rentResultList",rentResultList);
        //放置 交易页面
        if(!reMap.isEmpty()){
            resultView.setReMap(reMap);
            resultView.setStatus(StatusConfig.SUCCESS);
            resultView.setMessage("获取查询商品信息成功！");
        }else{
            resultView.setStatus(StatusConfig.FAIL);
            resultView.setMessage("获取查询商品信息失败！");
        }
        return resultView;
    }
}
