package com.zhzteam.zhz233.mapper.zlb;

import com.zhzteam.zhz233.model.zlb.GamesResult;
import com.zhzteam.zhz233.model.zlb.GoodsResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GamesMapper {
    /**
     * 返回 List<GamesResult> Limit N
     * @param gamestype
     * @param pagesize
     * @return
     */
    public List<GamesResult> selectTByKey(@Param("gamestype") Integer gamestype, @Param("pagesize") Integer pagesize);
    /**
     * 返回 List<GamesResult> Limit N
     * @param pagesize
     * @return
     */
    public List<GamesResult> selectTByHotKey(@Param("pagesize") Integer pagesize);
    /**
     * 返回 List<GamesResult> Limit N
     * @param pagesize
     * @return
     */
    public List<GamesResult> selectTByListKey(@Param("pagesize") Integer pagesize);

    /**
     * 游戏名 列表
     * @param pagesize
     * @return
     */
    public List<String> selectTByListName(@Param("pagesize") Integer pagesize);

    /**
     * 服务器 列表
     * @param gamesName
     * @return
     */
    public List<String> selectTByListServer(@Param("gamesName") String gamesName);

    /**
     * 大区 列表
     * @param serverName
     * @return
     */
    public List<String> selectTByListArea(@Param("gamesName") String gamesName, @Param("serverName") String serverName);
}
