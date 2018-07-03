package com.zhzteam.zhz233.service.wlh.impl;

import com.zhzteam.zhz233.mapper.wlh.PCBoardMapper;
import com.zhzteam.zhz233.service.wlh.PCBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @描述
 * @参数 $params
 * @返回值 $return
 * @创建人 wenliheng
 * @创建时间 2018/5/23
 */
@Service
public class PCBoardServiceImpl implements PCBoardService {

    @Autowired
    PCBoardMapper boardMapper;

    @Override
    public Map<Object, Object> selectByName(String boardName) {
        if (StringUtils.isEmpty(boardName)) {
            return null;
        }
        Map<Object, Object> map = boardMapper.selectByName(boardName);
        if (map.size() == 0){
            return null;
        }
        return map;
    }
}
