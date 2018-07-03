package com.zhzteam.zhz233.controller.zlb;

import com.zhzteam.zhz233.common.config.StatusConfig;
import com.zhzteam.zhz233.model.zlb.InvlaInfoResult;
import com.zhzteam.zhz233.model.zlb.PathResult;
import com.zhzteam.zhz233.model.zlb.ResultView;
import com.zhzteam.zhz233.service.zlb.impl.InvlaServiceImpl;
import com.zhzteam.zhz233.service.zlb.impl.RedisServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/zlb")
public class InvlaController {
    @Autowired
    RedisServiceImpl redisService;
    @Autowired
    InvlaServiceImpl invlaService;

    private ResultView resultView;

    private List<InvlaInfoResult> invlaInfoResultList;

    private Map<String,Object> reMap;

    @RequestMapping(value = "/getInvlaAutoInfo")
    public ResultView getInvlaAutoInfo(@RequestParam("uid") String uid){
        resultView = new ResultView();
        invlaInfoResultList = new ArrayList<InvlaInfoResult>();
        reMap = new HashMap<String, Object>();
        String accountNo = redisService.select(uid);
        if(accountNo != null){
            //获取 资金 数据
            invlaInfoResultList = invlaService.selectTByNO(accountNo);
            reMap.put("InvlaInfoList",invlaInfoResultList);
            if(!reMap.isEmpty()){
                //设置返回数据 集合
                resultView.setReMap(reMap);
                resultView.setStatus(StatusConfig.SUCCESS);
                resultView.setMessage("用户资金信息获取成功！");
            }else {
                resultView.setStatus(StatusConfig.FAIL);
                resultView.setMessage("用户资金信息获取为空！");
            }
        }else {
            resultView.setStatus(StatusConfig.FAIL);
            resultView.setMessage("用户资金信息获取失败！");
        }
        return resultView;
    }
}
