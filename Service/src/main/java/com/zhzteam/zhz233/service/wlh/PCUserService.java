package com.zhzteam.zhz233.service.wlh;

import com.zhzteam.zhz233.model.UserModel;
import com.zhzteam.zhz233.model.wlh.UserView;
import org.springframework.stereotype.Service;

/**
 * @描述
 * @参数 $params
 * @返回值 $return
 * @创建人 wenliheng
 * @创建时间 2018/5/22
 */
public interface PCUserService {
    UserModel selectByAccount(String username);

    UserView LoginJudge(String userName, String passWord);
}
