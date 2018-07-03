package com.zhzteam.zhz233.controller.zlb;

import com.zhzteam.zhz233.common.config.RedisConfig;
import com.zhzteam.zhz233.common.config.StatusConfig;
import com.zhzteam.zhz233.common.utils.AutoIncUtils;
import com.zhzteam.zhz233.common.utils.DateTimeUtils;
import com.zhzteam.zhz233.common.utils.DecimalUtils;
import com.zhzteam.zhz233.model.zlb.GoodsLeaseResult;
import com.zhzteam.zhz233.model.zlb.LeaseOrderInfo;
import com.zhzteam.zhz233.model.zlb.ResultView;
import com.zhzteam.zhz233.service.zlb.impl.GoodsServiceImpl;
import com.zhzteam.zhz233.service.zlb.impl.OrderServiceImpl;
import com.zhzteam.zhz233.service.zlb.impl.RedisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/zlb")
public class OrderController {
    @Autowired
    RedisServiceImpl redisServiceImpl;
    @Autowired
    GoodsServiceImpl goodsServiceImpl;
    @Autowired
    OrderServiceImpl orderServiceImpl;

    private LeaseOrderInfo leaseOrderInfo;

    private GoodsLeaseResult goodsLeaseResult;

    private ResultView resultView;

    private Map<String,Object> reMap;

    @RequestMapping(value = "/addRentOrder")
    public ResultView addRentOrder(@RequestParam("goods_no") String goods_no,
                                   @RequestParam("goods_time") Integer goods_time,
                                   @RequestParam("goods_night") Integer goods_night,
                                   @RequestParam("goods_day") Integer goods_day,
                                   @RequestParam("goods_week") Integer goods_week,
                                   @RequestParam("uid") String uid){
        resultView = new ResultView();
        leaseOrderInfo = new LeaseOrderInfo();
        goodsLeaseResult = new GoodsLeaseResult();
        reMap = new HashMap<String, Object>();
        if(goods_no != null
                && goods_time>= 0
                && goods_night >= 0
                && goods_day >= 0
                && goods_week >= 0
                && redisServiceImpl.exist(uid)){
            if(goodsServiceImpl.selectByGoodsNo(goods_no,1,1)){//检测商品有效性
                Date startTime = new Date();
                Date endTime = new Date();
                Double amount = 0.00;
                //获取 商品 信息 所属人
                goodsLeaseResult = goodsServiceImpl.selectTByGoodsNo(goods_no);
                if(goods_week > 0){
                    amount = DecimalUtils.mul(goodsLeaseResult.getGoods_week(),goods_week,2);
                    startTime = DateTimeUtils.getDateTime();
                    endTime = DateTimeUtils.addDay(7 * goods_week);
                }else if(goods_day > 0){
                    amount = DecimalUtils.mul(goodsLeaseResult.getGoods_day(),goods_day,2);
                    startTime = DateTimeUtils.getDateTime();
                    endTime = DateTimeUtils.addDay(goods_day);
                }else if(goods_night > 0){
                    amount = DecimalUtils.mul(goodsLeaseResult.getGoods_night(),goods_night,2);
                    startTime = DateTimeUtils.getDateTime(22,0,0);
                    endTime = DateTimeUtils.getDateTime(22 + 10 ,0,0);
                }else {
                    amount = DecimalUtils.mul(goodsLeaseResult.getGoods_amount(),goods_time,2);
                    startTime = DateTimeUtils.getDateTime();
                    endTime = DateTimeUtils.addHour(goods_time);
                }
                //获取 商品 购买人
                String buyerNo = redisServiceImpl.select(uid);
                //获取原 No
                String oldNo = orderServiceImpl.selectTByAuto();
                //获取 订单 No
                String orderNo = AutoIncUtils.getLeaseOrderNo(oldNo);

                //设置 订单 信息
                leaseOrderInfo.setOrder_no(orderNo);
                leaseOrderInfo.setGoods_no(goodsLeaseResult.getGoods_no());
                leaseOrderInfo.setAccount_no(goodsLeaseResult.getAccount_no());
                leaseOrderInfo.setBuyer_no(buyerNo);
                leaseOrderInfo.setOrder_amount(amount);
                leaseOrderInfo.setOrder_start_time(startTime);
                leaseOrderInfo.setOrder_end_time(endTime);
                leaseOrderInfo.setOrder_state(0);
                leaseOrderInfo.setUpdate_time(startTime);
                leaseOrderInfo.setCreate_time(startTime);
                //插入数据库
                if(orderServiceImpl.insertTByKey(leaseOrderInfo)){
                    //放入 缓存 或者 数据库
                    //redisServiceImpl.set("test",leaseOrderInfo,RedisConfig.REDIS_TIME_30MINUTE);
                    resultView.setStatus(StatusConfig.SUCCESS);
                    resultView.setMessage("添加订单成功！");
                }else {
                    resultView.setStatus(StatusConfig.FAIL);
                    resultView.setMessage("添加订单失败！");
                }
            }else {
                resultView.setStatus(StatusConfig.FAIL);
                resultView.setMessage("添加订单失败！");
            }
        }else{
            resultView.setStatus(StatusConfig.FAIL);
            resultView.setMessage("添加订单失败！");
        }
        return resultView;
    }
}
