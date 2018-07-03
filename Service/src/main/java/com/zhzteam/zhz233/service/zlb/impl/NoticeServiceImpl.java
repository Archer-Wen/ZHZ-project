package com.zhzteam.zhz233.service.zlb.impl;

import com.zhzteam.zhz233.mapper.zlb.NoticeMapper;
import com.zhzteam.zhz233.model.zlb.NoticeResult;
import com.zhzteam.zhz233.service.zlb.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    NoticeMapper noticeMapper;

    @Override
    public List<NoticeResult> selectTByKey(Integer noticetype, Integer noticerecomm, Integer pagesize) {
        return noticeMapper.selectTByKey(noticetype, noticerecomm, pagesize);
    }
}
