package com.zhzteam.zhz233.service.wlh.impl;

import com.zhzteam.zhz233.mapper.wlh.PCBBSMapper;
import com.zhzteam.zhz233.model.BBSModel;
import com.zhzteam.zhz233.model.wlh.ShowBBSView;
import com.zhzteam.zhz233.service.wlh.PCBBSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @描述
 * @参数 $params
 * @返回值 $return
 * @创建人 wenliheng
 * @创建时间 2018/5/23
 */
@Service
public class PCBBSServiceImpl implements PCBBSService {

    @Autowired
    PCBBSMapper bbsMapper;

    @Override
    public List<ShowBBSView> ShowBBS(Integer board_id) {
        List<ShowBBSView> showBBSView = bbsMapper.ShowBBS(board_id);
        return showBBSView;
    }

    @Override
    public boolean deleteBBS(Integer bbsId) {
        if (bbsId == null){
            return false;
        }
        Integer bbs_id = bbsMapper.deleteBBS(bbsId);
        if (bbs_id == null || bbs_id <= 0){
            return false;
        }
        return true;
    }

    @Override
    public BBSModel findOne(Integer bbsId) {
        if (bbsId == null){
            return null;
        }
        BBSModel bbsPojo = bbsMapper.findOne(bbsId);
        return bbsPojo;
    }

    @Override
    public Integer insertOne(BBSModel bbsPojo) {
        if (bbsPojo == null) {
            return null;
        }
        Integer bbs_id = bbsMapper.insertOne(bbsPojo);
        if (bbs_id == 0 || bbs_id == null){
            return null;
        }
        return bbs_id;
    }

    @Override
    public ShowBBSView showOneBBS(Integer bbsId) {
        if (bbsId == null){
            return null;
        }
        ShowBBSView bbsView = bbsMapper.ShowOneBBS(bbsId);
        return bbsView;
    }
}
