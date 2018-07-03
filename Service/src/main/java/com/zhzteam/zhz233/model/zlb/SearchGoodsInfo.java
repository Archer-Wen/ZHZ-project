package com.zhzteam.zhz233.model.zlb;

import java.io.Serializable;

public class SearchGoodsInfo implements Serializable {
    private String gamesName;//游戏名称
    private String gamesServer;//游戏服务器
    private String gamesArea;//游戏大区
    private String searchKey;//查询关键字
    private Integer priceRange;//价格范围
    private Integer authenticate;//认证类型
    private Integer goodsType;//商品类型
    private Integer goodsSort;//排序方式
    private Integer currentPage;//当前页码

    public String getGamesName() {
        return gamesName;
    }

    public void setGamesName(String gamesName) {
        this.gamesName = gamesName;
    }

    public String getGamesServer() {
        return gamesServer;
    }

    public void setGamesServer(String gamesServer) {
        this.gamesServer = gamesServer;
    }

    public String getGamesArea() {
        return gamesArea;
    }

    public void setGamesArea(String gamesArea) {
        this.gamesArea = gamesArea;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public Integer getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(Integer priceRange) {
        this.priceRange = priceRange;
    }

    public Integer getAuthenticate() {
        return authenticate;
    }

    public void setAuthenticate(Integer authenticate) {
        this.authenticate = authenticate;
    }

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public Integer getGoodsSort() {
        return goodsSort;
    }

    public void setGoodsSort(Integer goodsSort) {
        this.goodsSort = goodsSort;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
}
