package com.zhzteam.zhz233.service.wlh.impl;

import com.zhzteam.zhz233.mapper.wlh.PCUserMapper;
import com.zhzteam.zhz233.model.UserModel;
import com.zhzteam.zhz233.model.wlh.UserView;
import com.zhzteam.zhz233.service.wlh.PCUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @描述
 * @参数 $params
 * @返回值 $return
 * @创建人 wenliheng
 * @创建时间 2018/5/22
 */
@Service
public class PCUserServiceImpl implements PCUserService {
    @Autowired
    PCUserMapper userMapper;

    @Override
    public UserModel selectByAccount(String username){
        if (StringUtils.isEmpty(username)){
            return null;
        }
        return userMapper.selectByAccount(username);
    }

    @Override
    public UserView LoginJudge(String userName, String passWord) {
        UserModel userPojo = userMapper.selectByAccount(userName);
        if(userPojo == null){
            return null;
        }
        if(passWord.equals(userPojo.getPassword())){
            UserView userView = new UserView();
            userView.setAccount_no(userPojo.getAccount_no());
            userView.setAccount(userPojo.getAccount());
            userView.setCell_phone(userPojo.getCell_phone());
            userView.setAccess(userPojo.getAccess());
            return userView;
        }
        return null;
    }
}
