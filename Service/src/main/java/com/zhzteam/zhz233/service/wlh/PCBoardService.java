package com.zhzteam.zhz233.service.wlh;

import java.util.Map;

/**
 * @描述
 * @参数 $params
 * @返回值 $return
 * @创建人 wenliheng
 * @创建时间 2018/5/23
 */
public interface PCBoardService {

    Map<Object,Object> selectByName(String boardName);
}
