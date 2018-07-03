package com.zhzteam.zhz233.service.zlb.impl;

import com.zhzteam.zhz233.mapper.zlb.GamesMapper;
import com.zhzteam.zhz233.model.zlb.GamesResult;
import com.zhzteam.zhz233.service.zlb.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GamesServiceImpl implements GamesService {

    @Autowired
    GamesMapper gamesMapper;

    @Override
    public List<GamesResult> selectTByKey(Integer gamestype, Integer pagesize) {
        return gamesMapper.selectTByKey(gamestype, pagesize);
    }

    @Override
    public List<GamesResult> selectTByHotKey(Integer pagesize) {
        return gamesMapper.selectTByHotKey(pagesize);
    }

    @Override
    public List<GamesResult> selectTByListKey(Integer pagesize) {
        return gamesMapper.selectTByListKey(pagesize);
    }

    @Override
    public List<String> selectTByListName(Integer pagesize) {
        return gamesMapper.selectTByListName(pagesize);
    }

    @Override
    public List<String> selectTByListServer(String gamesName) {
        return gamesMapper.selectTByListServer(gamesName);
    }

    @Override
    public List<String> selectTByListArea(String gamesName, String serverName) {
        return gamesMapper.selectTByListArea(gamesName, serverName);
    }
}
