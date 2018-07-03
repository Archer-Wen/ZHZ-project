package com.zhzteam.zhz233.service.zlb;

import com.zhzteam.zhz233.model.zlb.NoticeResult;

import java.util.List;

public interface NoticeService {
    /**
     * 返回 List<NoticeResult> Limit N
     * @param noticetype
     * @param noticerecomm
     * @return
     */
    public List<NoticeResult> selectTByKey(Integer noticetype, Integer noticerecomm, Integer pagesize);

}
