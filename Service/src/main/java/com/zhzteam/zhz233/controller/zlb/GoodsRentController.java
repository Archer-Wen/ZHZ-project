package com.zhzteam.zhz233.controller.zlb;

import com.zhzteam.zhz233.common.config.StatusConfig;
import com.zhzteam.zhz233.model.zlb.GoodsRentResult;
import com.zhzteam.zhz233.model.zlb.ResultView;
import com.zhzteam.zhz233.service.zlb.impl.GoodsRentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/zlb")
public class GoodsRentController {
    @Autowired
    GoodsRentServiceImpl goodsRentServiceImpl;

    private ResultView resultView;

    private List<GoodsRentResult> goodsRentResultList;

    private Map<String,Object> reMap;

    @RequestMapping(value = "/getGoodsRentInfo")
    public ResultView getGoodsRentInfo(HttpServletRequest hsRequest){
        //初始化 容器
        resultView = new ResultView();
        goodsRentResultList = new ArrayList<GoodsRentResult>();
        reMap = new HashMap<String, Object>();
        //放置 数据
        goodsRentResultList = goodsRentServiceImpl.selectTByKey(0,0,0,10);
        reMap.put("goodsRentResultList",goodsRentResultList);
        if(!reMap.isEmpty()){
            resultView.setReMap(reMap);
            resultView.setStatus(StatusConfig.SUCCESS);
            resultView.setMessage("获取出租商品信息成功！");
        }else{
            resultView.setStatus(StatusConfig.FAIL);
            resultView.setMessage("获取出租商品信息失败！");
        }
        return resultView;
    }
}
