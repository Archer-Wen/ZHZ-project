package com.zhzteam.zhz233.mapper.zlb;

import com.zhzteam.zhz233.model.zlb.BlacklistResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlacklistMapper {
    /**
     * 返回 List<BlacklistResult> Limit N
     * @param pagesize
     * @return
     */
    public List<BlacklistResult> selectTByKey(@Param("pagesize") Integer pagesize);

}
