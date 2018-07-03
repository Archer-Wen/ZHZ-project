package com.zhzteam.zhz233.controller.wlh;

import com.zhzteam.zhz233.model.wlh.UserView;
import com.zhzteam.zhz233.service.wlh.PCUserService;
import com.zhzteam.zhz233.service.zlb.RedisService;
import com.zhzteam.zhz233.service.zlb.impl.RedisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @描述
 * @参数 $params
 * @返回值 $return
 * @创建人 wenliheng
 * @创建时间 2018/5/22
 */
@RestController
@RequestMapping(value = "/wlh")
public class PCUserController {
    @Autowired
    PCUserService userService;
    @Autowired
    RedisServiceImpl redisService;

    @ResponseBody
    @RequestMapping(value = "/Login",method = {RequestMethod.POST})
    public Object Login(HttpServletResponse response, HttpServletRequest request, String UserName, String PassWord){
        if(StringUtils.isEmpty(UserName) || StringUtils.isEmpty(PassWord)){
            return "用户名和密码不能为空";
        }
        UserView userView = userService.LoginJudge(UserName,PassWord);
        if(userView == null){
            return "找不到用户或密码错误";
        }
        redisService.insert(request.getSession().getId(),userView.getAccount(),1800L);
        System.out.println(request.getSession().getId());
        return request.getSession().getId();
    }
}
