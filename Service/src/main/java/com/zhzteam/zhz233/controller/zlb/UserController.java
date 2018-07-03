package com.zhzteam.zhz233.controller.zlb;

import com.zhzteam.zhz233.common.config.*;
import com.zhzteam.zhz233.common.utils.*;
import com.zhzteam.zhz233.model.zlb.*;
import com.zhzteam.zhz233.service.zlb.impl.RedisServiceImpl;
import com.zhzteam.zhz233.service.zlb.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/zlb")
public class UserController {
    @Autowired
    RedisServiceImpl redisServiceImpl;

    @Autowired
    UserServiceImpl userServiceImpl;

    private ResultView resultView;
    private UserResult userResult;
    private CodeResult codeResult;
    private SMSResult smsResult;

    private Map<String,Object> reMap;

    @RequestMapping(value = "/userBean/getUserInfo")
    public ResultView register(HttpServletRequest hsRequest,@RequestParam("uid") String uid){
        //初始化 容器
        resultView = new ResultView();
        userResult = new UserResult();
        reMap = new HashMap<String, Object>();
        if(redisServiceImpl.exist(uid)){
            //读取 数据
            userResult = userServiceImpl.selectTByNo(redisServiceImpl.select(uid));
            String userName = "";
            if(userResult != null){
                userName = userResult.getAccount();
                //放置User 信息
                reMap.put("userName",userName);
                if(!reMap.isEmpty()){
                    resultView.setReMap(reMap);
                    resultView.setStatus(StatusConfig.SUCCESS);
                    resultView.setMessage("获取用户信息成功！");
                }else {
                    resultView.setStatus(StatusConfig.FAIL);
                    resultView.setMessage("获取用户信息为空！");
                }
            }else{
                resultView.setStatus(StatusConfig.FAIL);
                resultView.setMessage("获取用户信息失败！");
            }
        }else{
            resultView.setStatus(StatusConfig.FAIL);
            resultView.setMessage("获取用户信息失败！");
        }
        return resultView;
    }

    @RequestMapping(value = "/userBean/checkCellPhone")
    public ResultView checkCellPhone(@RequestParam("cellphone") String cellphone) {
        //初始化对象
        resultView = new ResultView();

        if(cellphone != null){//验证数据 合法性
            if(REVUtils.isLogonPhone(cellphone) && !userServiceImpl.selectTByCellPhone(cellphone)){
                resultView.setStatus(StatusConfig.SUCCESS);
                resultView.setMessage("手机号未注册！");
            }else {
                resultView.setStatus(StatusConfig.FAIL);
                resultView.setMessage("手机号已注册！");
            }
        }else {
            resultView.setStatus(StatusConfig.FAIL);
            resultView.setMessage("手机号验证失败！");
        }
        return resultView;
    }

    @RequestMapping(value = "/userBean/checkUserName")
    public ResultView checkUserName(@RequestParam("username") String username) {
        //初始化对象
        resultView = new ResultView();

        if(username != null){//验证数据 合法性
            if(REVUtils.isLogonInfo(username) && !userServiceImpl.selectTByUserName(username)){
                resultView.setStatus(StatusConfig.SUCCESS);
                resultView.setMessage("用户名未注册！");
            }else {
                resultView.setStatus(StatusConfig.FAIL);
                resultView.setMessage("用户名已注册！");
            }
        }else {
            resultView.setStatus(StatusConfig.FAIL);
            resultView.setMessage("用户名验证失败！");
        }
        return resultView;
    }

    @RequestMapping(value = "/userBean/checkCode")
    public ResultView checkCode(@RequestParam("cellphone") String cellphone,@RequestParam("code") String code) {
        //初始化对象
        resultView = new ResultView();
        if(cellphone != null && code != null) {//验证数据 合法性
            if(REVUtils.isLogonPhone(cellphone) && redisServiceImpl.exist(cellphone)){
                if(REVUtils.isLogonInfo(code) && redisServiceImpl.select(cellphone).equals(code)){
                    resultView.setStatus(StatusConfig.SUCCESS);
                    resultView.setMessage("验证码验证成功！");
                }else {
                    resultView.setStatus(StatusConfig.FAIL);
                    resultView.setMessage("验证码错误！");
                }
            }else {
                resultView.setStatus(StatusConfig.FAIL);
                resultView.setMessage("验证码验证失效！");
            }
        }else {
            resultView.setStatus(StatusConfig.FAIL);
            resultView.setMessage("验证码验证失败！");
        }
        return resultView;
    }

    @RequestMapping(value = "/userBean/getCode")
    public ResultView getCode(@RequestParam("cellphone") String cellphone){
        //初始化对象
        resultView = new ResultView();
        codeResult = new CodeResult();
        smsResult = new SMSResult();

        if(cellphone != null){//验证数据 合法性
            if(REVUtils.isLogonPhone(cellphone) && !userServiceImpl.selectTByCellPhone(cellphone)){
                codeResult = SMSUtils.cerateMsg(6);//获取信息组合
                smsResult = SMSUtils.execute(cellphone, codeResult.getMsg());
                if(smsResult != null && smsResult.getRespCode() != null){
                    if(smsResult.getRespCode().equals(SMSConfig.RESPCODE_SUCCESS)){
                        if(redisServiceImpl.exist(cellphone)){
                            redisServiceImpl.drop(cellphone);
                        }
                        redisServiceImpl.insert(cellphone,codeResult.getCode(),RedisConfig.REDIS_TIME_30MINUTE);
                        resultView.setStatus(StatusConfig.SUCCESS);
                        resultView.setMessage("验证码发送成功！");
                    }else{
                        resultView.setStatus(StatusConfig.FAIL);
                        resultView.setMessage("发送频率过快，请稍后再试！");
                    }
                }else{
                    resultView.setStatus(StatusConfig.FAIL);
                    resultView.setMessage("网络异常！");
                }
            }else{
                resultView.setStatus(StatusConfig.FAIL);
                resultView.setMessage("手机号错误或不可用！");
            }
        }else{
            resultView.setStatus(StatusConfig.FAIL);
            resultView.setMessage("验证码获取失败！");
        }
        return resultView;
    }

    @RequestMapping(value = "/userBean/register")
    public ResultView register(HttpServletRequest hsRequest,@RequestBody RegisterInfo registerInfo) {
        HttpSession httpSession = hsRequest.getSession();
        //初始化对象
        resultView = new ResultView();
        userResult = new UserResult();
        reMap = new HashMap<String, Object>();

        if(registerInfo != null){//验证 数据 合法性
            if(registerInfo.getUsername() != null && REVUtils.isLogonInfo(registerInfo.getUsername())){
                if(registerInfo.getCellphone() != null && REVUtils.isLogonPhone(registerInfo.getCellphone())){
                    if(registerInfo.getPassword() != null && REVUtils.isLogonInfo(registerInfo.getPassword())){
                        if(registerInfo.getCode() != null && REVUtils.isLogonInfo(registerInfo.getCode())){
                            if(!userServiceImpl.selectTByUserName(registerInfo.getUsername())){
                                if(!userServiceImpl.selectTByCellPhone(registerInfo.getCellphone())){
                                    if(redisServiceImpl.exist(registerInfo.getCellphone())){
                                        if(redisServiceImpl.select(registerInfo.getCellphone()).equals(registerInfo.getCode())){
                                           //去除缓存
                                            redisServiceImpl.drop(registerInfo.getCellphone());
                                            //获取Auto 自增编号
                                            String autoNo = AutoIncUtils.getAccountNo(userServiceImpl.selectTByAuto());
                                            //注册 一条信息
                                            Boolean registerFlag = userServiceImpl.insertTByKey(
                                                    registerInfo.getUsername(),
                                                    registerInfo.getCellphone(),
                                                    registerInfo.getPassword(),
                                                    autoNo);

                                            if(registerFlag){//判断注册成功
                                                userResult = userServiceImpl.selectTByKey(registerInfo.getUsername(), registerInfo.getPassword());
                                                if(userResult != null) {//注册 登录用户
                                                    String uid= httpSession.getId();
                                                    if(redisServiceImpl.exist(uid)){
                                                        redisServiceImpl.drop(uid);
                                                    }
                                                    redisServiceImpl.insert(uid, userResult.getAccount_no(),RedisConfig.REDIS_TIME_30MINUTE);
                                                    reMap.put("uid",uid);
                                                    if(!reMap.isEmpty()){
                                                        resultView.setReMap(reMap);
                                                        resultView.setStatus(StatusConfig.SUCCESS);
                                                        resultView.setMessage("注册登录成功！");
                                                    }else {
                                                        resultView.setStatus(StatusConfig.SUCCESS);
                                                        resultView.setMessage("系统错误！");
                                                    }
                                                }else{
                                                    resultView.setStatus(StatusConfig.SUCCESS);
                                                    resultView.setMessage("注册成功！");
                                                }
                                            }else{
                                                resultView.setStatus(StatusConfig.FAIL);
                                                resultView.setMessage("注册失败！");
                                            }
                                        }else{
                                            resultView.setStatus(StatusConfig.FAIL);
                                            resultView.setMessage("验证码错误！");
                                        }
                                    }else{
                                        resultView.setStatus(StatusConfig.FAIL);
                                        resultView.setMessage("验证码无效！");
                                    }
                                }else{
                                    resultView.setStatus(StatusConfig.FAIL);
                                    resultView.setMessage("手机号已存在！");
                                }
                            }else{
                                resultView.setStatus(StatusConfig.FAIL);
                                resultView.setMessage("用户名已存在！");
                            }
                        }else{
                            resultView.setStatus(StatusConfig.FAIL);
                            resultView.setMessage("验证码信息错误！");
                        }
                    }else{
                        resultView.setStatus(StatusConfig.FAIL);
                        resultView.setMessage("密码信息错误！");
                    }
                }else{
                    resultView.setStatus(StatusConfig.FAIL);
                    resultView.setMessage("手机号信息错误！");
                }
            }else{
                resultView.setStatus(StatusConfig.FAIL);
                resultView.setMessage("用户名信息错误！");
            }
        }else{
            resultView.setStatus(StatusConfig.FAIL);
            resultView.setMessage("注册信息错误！");
        }
        return resultView;
    }

    @RequestMapping(value = "/userBean/login")
    public ResultView logon(HttpServletRequest hsRequest, @RequestBody UserInfo userInfo){
        HttpSession httpSession = hsRequest.getSession();
        //初始化对象
        resultView = new ResultView();
        userResult = new UserResult();
        reMap = new HashMap<String, Object>();
        if(userInfo != null){
            if(userInfo.getUsername() != null && REVUtils.isLogonInfo(userInfo.getUsername())){
                if(userInfo.getPassword() != null && REVUtils.isLogonInfo(userInfo.getPassword())){
                    userResult = userServiceImpl.selectTByKey(userInfo.getUsername(), userInfo.getPassword());
                    if(userResult != null){//判断数据库数据 验证
                        String uid = httpSession.getId();
                        if(redisServiceImpl.exist(uid)){
                            redisServiceImpl.drop(uid);
                        }
                        redisServiceImpl.insert(uid, userResult.getAccount_no(),RedisConfig.REDIS_TIME_30MINUTE);
                        reMap.put("uid",uid);
                        if(!reMap.isEmpty()){
                            resultView.setReMap(reMap);
                            resultView.setStatus(StatusConfig.SUCCESS);
                            resultView.setMessage("登录成功！");
                        }else {
                            resultView.setStatus(StatusConfig.FAIL);
                            resultView.setMessage("系统错误！");
                        }
                    }else{
                        resultView.setStatus(StatusConfig.FAIL);
                        resultView.setMessage("登录失败！");
                    }
                }else{
                    resultView.setStatus(StatusConfig.FAIL);
                    resultView.setMessage("密码信息错误！");
                }
            }else{
                resultView.setStatus(StatusConfig.FAIL);
                resultView.setMessage("用户名信息错误！");
            }
        }else{
            resultView.setStatus(StatusConfig.FAIL);
            resultView.setMessage("登录信息错误！");
        }
        return resultView;
    }

    @RequestMapping("/login")
    public PathResult login(){
        PathResult pathResult = new PathResult();
        pathResult.setPath("/login");
        pathResult.setStatus(StatusConfig.SUCCESS);
        return pathResult;
    }

    @RequestMapping("/register")
    public PathResult register(){
        PathResult pathResult = new PathResult();
        pathResult.setPath("/register");
        pathResult.setStatus(StatusConfig.SUCCESS);
        return pathResult;
    }
}
