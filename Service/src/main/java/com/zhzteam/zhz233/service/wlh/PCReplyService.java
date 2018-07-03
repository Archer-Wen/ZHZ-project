package com.zhzteam.zhz233.service.wlh;

import com.zhzteam.zhz233.model.ReplyModel;
import com.zhzteam.zhz233.model.wlh.ShowReplyView;

import java.util.List;

/**
 * @描述
 * @参数 $params
 * @返回值 $return
 * @创建人 wenliheng
 * @创建时间 2018/5/23
 */
public interface PCReplyService {
    boolean deleteReplyByBBSId(Integer bbsId);

    Integer CountByBBSId(Integer bbsId);

    List<ShowReplyView> ShowReply(Integer bbsId);

    Integer insertReply(String userNo,Integer bbsId,String count);
}
