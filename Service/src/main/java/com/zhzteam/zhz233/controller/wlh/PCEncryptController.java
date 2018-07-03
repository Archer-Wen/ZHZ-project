package com.zhzteam.zhz233.controller.wlh;

import com.zhzteam.zhz233.common.utils.RSACoder;
import com.zhzteam.zhz233.model.GoodsRentModel;
import com.zhzteam.zhz233.model.LeaseOrderModel;
import com.zhzteam.zhz233.model.UserModel;
import com.zhzteam.zhz233.model.wlh.ShowPcOrderView;
import com.zhzteam.zhz233.service.wlh.PCEncryptService;
import com.zhzteam.zhz233.service.wlh.PCGoodsRentService;
import com.zhzteam.zhz233.service.wlh.PCLeaseOrderService;
import com.zhzteam.zhz233.service.wlh.PCUserService;
import com.zhzteam.zhz233.service.zlb.impl.RedisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @描述
 * @参数 $params
 * @返回值 $return
 * @创建人 wenliheng
 * @创建时间 2018/5/24
 */
@RestController
@RequestMapping(value = "/wlh")
public class PCEncryptController {

    @Autowired
    PCLeaseOrderService leaseOrderService;
    @Autowired
    PCGoodsRentService goodsRentService;
    @Autowired
    RedisServiceImpl redisService;
    @Autowired
    PCEncryptService encryptService;
    @Autowired
    PCUserService userService;

    @ResponseBody
    @RequestMapping(value = "/Encrypt")
    public Object Encrypt(HttpServletRequest request, HttpServletResponse response,
                          String orderNo, String publicKey,String userName,String session){
        if(StringUtils.isEmpty(orderNo) || StringUtils.isEmpty(userName) || StringUtils.isEmpty(session)){
            return null;
        }
        if (redisService.exist(session)){//用户验证
            String redisUser = redisService.select(session);
            if (!redisUser.equals(userName)){
                return null;
            }
        }
        LeaseOrderModel leaseOrderPojo = leaseOrderService.findOne(orderNo);
        if(leaseOrderPojo == null){
            return null;
        }
        GoodsRentModel goodsRentPojo = goodsRentService.selectByGoodsNo(leaseOrderPojo.getGoods_no());
        String passWord = goodsRentPojo.getGoods_password();
        RSACoder rsaCoder = new RSACoder();
        String[] strs = publicKey.split(" ");
        publicKey = strs[0];
        for (int i=1; i<strs.length; i++){
            publicKey += "+"+strs[i];
        }
        byte[] b = new byte[0];
        try {
            b = rsaCoder.encryptByPublicKey(passWord,publicKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    @ResponseBody
    @RequestMapping(value = "/getOrderInfo")
    public Object getOrderInfo(HttpServletResponse response,HttpServletRequest request,
                               String orderNo,String userName,String session){
        if (redisService.exist(session)){//用户验证
            String redisUser = redisService.select(session);
            if (!redisUser.equals(userName)){
                return "用户信息过期，重新登陆";
            }
        }
        if (StringUtils.isEmpty(orderNo)){
            return null;
        }
        UserModel userModel = userService.selectByAccount(userName);
        String userNo = userModel.getAccount_no();
        ShowPcOrderView orderView = encryptService.findOrderInfo(orderNo);
        if(orderView == null){
            return null;
        }
        if (!orderView.getBuyer_no().equals(userNo)) {//非本人订单
            return null;
        }
        return  orderView;
    }

    @ResponseBody
    @RequestMapping(value = "/JudgeTimeout")
    public Object JudgeTimeout(HttpServletRequest request,HttpServletResponse response,
                               String orderNo){
        LeaseOrderModel leaseOrder = leaseOrderService.findOne(orderNo);
        Integer state = leaseOrder.getOrder_state();
        if(state != 4){
            return 0;
        }
        Date endtime = leaseOrder.getOrder_end_time();
        Date nowtime = new Date();
        int flag = endtime.compareTo(nowtime);//等于返回0，endtime大返回1，endtime小返回-1
        if(flag == 0 || flag == -1){
            return 0;
        }
        return 1;
    }
}
