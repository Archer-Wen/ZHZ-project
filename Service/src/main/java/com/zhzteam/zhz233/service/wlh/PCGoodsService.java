package com.zhzteam.zhz233.service.wlh;

import com.zhzteam.zhz233.model.wlh.ShowRentView;

import java.util.List;

/**
 * @描述
 * @参数 $params
 * @返回值 $return
 * @创建人 wenliheng
 * @创建时间 2018/5/23
 */
public interface PCGoodsService {
    public List<ShowRentView> showRent(String gameName);
}
