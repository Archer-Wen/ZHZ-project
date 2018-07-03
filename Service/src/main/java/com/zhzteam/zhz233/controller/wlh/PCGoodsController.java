package com.zhzteam.zhz233.controller.wlh;

import com.zhzteam.zhz233.model.wlh.ShowRentView;
import com.zhzteam.zhz233.service.wlh.PCGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @描述
 * @参数 $params
 * @返回值 $return
 * @创建人 wenliheng
 * @创建时间 2018/5/23
 */
@RestController
@RequestMapping(value = "/wlh")
public class PCGoodsController {

    @Autowired
    PCGoodsService goodsService;

    @ResponseBody
    @RequestMapping(value = "/show_rent",method = {RequestMethod.GET})
    public Object showRent(HttpServletResponse response, HttpServletRequest request,
                                       String gameName){
        if (StringUtils.isEmpty(gameName)){
            return "板块错误";
        }
        List<ShowRentView> list = goodsService.showRent(gameName);
        return list;
    }
}
