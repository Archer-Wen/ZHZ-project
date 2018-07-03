package com.zhzteam.zhz233.service.wlh.impl;

import com.zhzteam.zhz233.mapper.wlh.PCReplyMapper;
import com.zhzteam.zhz233.model.ReplyModel;
import com.zhzteam.zhz233.model.wlh.ShowReplyView;
import com.zhzteam.zhz233.service.wlh.PCReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @描述
 * @参数 $params
 * @返回值 $return
 * @创建人 wenliheng
 * @创建时间 2018/5/23
 */
@Service
public class PCReplyServiceImpl implements PCReplyService {

    @Autowired
    PCReplyMapper replyMapper;

    @Override
    public boolean deleteReplyByBBSId(Integer bbsId) {
        if(bbsId == null) {
            return false;
        }
        Integer count = replyMapper.deleteReplyByBBSId(bbsId);
        if(count == null || count <= 0){
            return false;
        }
        return true;
    }

    @Override
    public Integer CountByBBSId(Integer bbsId) {
        if (bbsId == null){
            return 0;
        }
        Integer count = replyMapper.CountByBBSId(bbsId);
        return count;
    }

    @Override
    public List<ShowReplyView> ShowReply(Integer bbsId) {
        if (bbsId == null){
            return null;
        }
        List<ShowReplyView> replyView = replyMapper.ShowReply(bbsId);
        return replyView;
    }

    @Override
    public Integer insertReply(String userNo, Integer bbsId, String count) {
        if (StringUtils.isEmpty(userNo) || bbsId==null || StringUtils.isEmpty(count)){
            return null;
        }
        ReplyModel replyModel = new ReplyModel();
        replyModel.setAccount_no(userNo);
        replyModel.setReply_count(count);
        replyModel.setBbs_id(bbsId);
        replyModel.setCreate_time(LocalDateTime.now());
        Integer flag = replyMapper.insertReply(replyModel);
        return flag;
    }


}
