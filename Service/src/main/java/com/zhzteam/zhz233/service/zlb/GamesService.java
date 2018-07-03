package com.zhzteam.zhz233.service.zlb;

import com.zhzteam.zhz233.model.zlb.GamesResult;
import com.zhzteam.zhz233.model.zlb.GoodsResult;

import java.util.List;

public interface GamesService {
    /**
     * 返回 List<GamesResult> Limit N
     * @param gamestype
     * @param pagesize
     * @return
     */
    public List<GamesResult> selectTByKey(Integer gamestype, Integer pagesize);
    /**
     * 返回 List<GamesResult> Limit N
     * @param pagesize
     * @return
     */
    public List<GamesResult> selectTByHotKey(Integer pagesize);
    /**
     * 返回 List<GamesResult> Limit N
     * @param pagesize
     * @return
     */
    public List<GamesResult> selectTByListKey(Integer pagesize);

    /**
     * 游戏名 列表
     * @param pagesize
     * @return
     */
    public List<String> selectTByListName(Integer pagesize);

    /**
     * 服务器 列表
     * @param gamesName
     * @return
     */
    public List<String> selectTByListServer(String gamesName);

    /**
     * 大区 列表
     * @param serverName
     * @return
     */
    public List<String> selectTByListArea(String gamesName, String serverName);

}
