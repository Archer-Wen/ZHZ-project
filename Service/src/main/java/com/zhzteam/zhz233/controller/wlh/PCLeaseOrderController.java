package com.zhzteam.zhz233.controller.wlh;

import com.zhzteam.zhz233.model.wlh.UserRentOrderView;
import com.zhzteam.zhz233.service.wlh.PCLeaseOrderService;
import com.zhzteam.zhz233.service.wlh.PCUserService;
import com.zhzteam.zhz233.service.zlb.RedisService;
import com.zhzteam.zhz233.service.zlb.impl.RedisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
public class PCLeaseOrderController {

    @Autowired
    PCLeaseOrderService leaseOrderService;
    @Autowired
    RedisServiceImpl redisService;
    @Autowired
    PCUserService userService;

    @ResponseBody
    @RequestMapping(value = "/showBuyerOrder")
    public Object showBuyerOrder(HttpServletResponse response, HttpServletRequest request,
                                 String sessionId, String user_name,Integer state) throws IOException {
        if(StringUtils.isEmpty(sessionId)){
            return "无效用户信息";
        }
        String username = (String) redisService.select(sessionId);
        if (StringUtils.isEmpty(username) || !username.equals(user_name)){
            return "无效用户信息";
        }
        String userNo = userService.selectByAccount(username).getAccount_no();
        //String userNoTest = "201800000002";//Test
        List<UserRentOrderView> list = leaseOrderService.showBuyerOrder(userNo,state);
        return list;
    }
}
