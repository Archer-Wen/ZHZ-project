package com.zhzteam.zhz233.service.wlh;

import com.zhzteam.zhz233.model.BBSModel;
import com.zhzteam.zhz233.model.wlh.ShowBBSView;

import java.util.List;

/**
 * @描述
 * @参数 $params
 * @返回值 $return
 * @创建人 wenliheng
 * @创建时间 2018/5/23
 */
public interface PCBBSService {

    List<ShowBBSView> ShowBBS(Integer board_id);

    boolean deleteBBS(Integer bbsId);

    BBSModel findOne(Integer bbsId);

    Integer insertOne(BBSModel bbsPojo);

    ShowBBSView showOneBBS(Integer bbsId);
}
