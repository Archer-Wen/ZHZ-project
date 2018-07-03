package com.zhzteam.zhz233.controller.zlb;

import com.zhzteam.zhz233.common.config.StatusConfig;
import com.zhzteam.zhz233.model.zlb.*;
import com.zhzteam.zhz233.service.zlb.impl.BlacklistServiceImpl;
import com.zhzteam.zhz233.service.zlb.impl.OrderServiceImpl;
import com.zhzteam.zhz233.service.zlb.impl.NoticeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/zlb")
public class IndexController {
    @Autowired
    NoticeServiceImpl noticeServiceImpl;
    @Autowired
    BlacklistServiceImpl blacklistServiceImpl;
    @Autowired
    OrderServiceImpl leaseService;

    private ResultView resultView;

    private List<NoticeResult> noticeResultList;
    private List<BlacklistResult> blacklistResultList;
    private List<LeaseOrderResult> leaseOrderResultList;

    private Map<String,Object> reMap;

    @RequestMapping(value = "/getIndexAutoInfo")
    public ResultView getIndexInfo(){
        //初始化 容器
        resultView = new ResultView();
        noticeResultList = new ArrayList<NoticeResult>();
        blacklistResultList = new ArrayList<BlacklistResult>();
        leaseOrderResultList = new ArrayList<LeaseOrderResult>();
        reMap = new HashMap<String, Object>();
        //公告活动
        noticeResultList = noticeServiceImpl.selectTByKey(1,1,5);
        reMap.put("noticeList",noticeResultList);
        //入门须知
        noticeResultList = noticeServiceImpl.selectTByKey(2,1,5);
        reMap.put("newbieList",noticeResultList);
        //系统更新
        noticeResultList = noticeServiceImpl.selectTByKey(3,1,5);
        reMap.put("updateList",noticeResultList);
        //获取黑名单
        blacklistResultList = blacklistServiceImpl.selectTByKey(6);
        reMap.put("blackList",blacklistResultList);
        //获取展示订单
        leaseOrderResultList = leaseService.selectTByKey(6);
        reMap.put("leaseList", leaseOrderResultList);
        if(!reMap.isEmpty()){
                resultView.setReMap(reMap);
                resultView.setStatus(StatusConfig.SUCCESS);
                resultView.setMessage("获取信息成功！");
        }else{
            resultView.setStatus(StatusConfig.FAIL);
            resultView.setMessage("获取信息失败！");
        }
        return resultView;
    }

    @RequestMapping("/index")
    public PathResult index(){
        PathResult  pathResult = new PathResult();
        pathResult.setPath("/index");
        pathResult.setStatus(StatusConfig.SUCCESS);
        return pathResult;
    }
}
