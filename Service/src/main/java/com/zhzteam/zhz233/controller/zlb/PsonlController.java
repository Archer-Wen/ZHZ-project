package com.zhzteam.zhz233.controller.zlb;

import com.zhzteam.zhz233.common.config.FileConfig;
import com.zhzteam.zhz233.common.config.RedisConfig;
import com.zhzteam.zhz233.common.config.SMSConfig;
import com.zhzteam.zhz233.common.config.StatusConfig;
import com.zhzteam.zhz233.common.utils.AutoIncUtils;
import com.zhzteam.zhz233.common.utils.REVUtils;
import com.zhzteam.zhz233.common.utils.SMSUtils;
import com.zhzteam.zhz233.common.utils.UploadUtils;
import com.zhzteam.zhz233.model.zlb.*;
import com.zhzteam.zhz233.service.zlb.*;
import com.zhzteam.zhz233.service.zlb.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/zlb")
public class PsonlController {
    @Autowired
    RedisServiceImpl redisService;
    @Autowired
    AccountService accountService;
    @Autowired
    InvlaService invlaService;
    @Autowired
    UserService userService;
    @Autowired
    CertificationService certificationService;
    @Autowired
    FileURLService fileURLService;
    @Autowired
    RechargeService rechargeService;

    private ResultView resultView;
    private AccountResult accountResult;
    private CodeResult codeResult;
    private SMSResult smsResult;

    private List<InvlaResult> invlaResultList;

    private Map<String,Object> reMap;

    @RequestMapping(value = "/getUserAuthInfo")
    public ResultView getUserAuthInfo(@RequestParam("uid") String uid){
        resultView = new ResultView();
        String accountNo = redisService.select(uid);

        return resultView;
    }


    @RequestMapping(value = "/recharge")
    public ResultView recharge(@RequestParam("money") Double money,
                               @RequestParam("uid") String uid){
        resultView = new ResultView();
        accountResult = new AccountResult();
        String accountNo = redisService.select(uid);
        if(money != null && accountNo != null){
            accountResult = accountService.selectTByANO(accountNo);
            if(accountResult != null && accountResult.getCertification() == 1){//验证信息有效性
                //invlaService
                accountService.updateAvailableByPwdANo(money,accountNo);
                //获取 Old Invla No
                String oldInvlaNo = invlaService.selectTByAuto();
                String newInvlaNo = AutoIncUtils.getInvlaOrderNo(oldInvlaNo);
                invlaService.insertTByKey(newInvlaNo,accountNo,2,money);
                //recharge Order
                String oldRechargeNo = rechargeService.selectTByAuto();
                String newRechargeNo = AutoIncUtils.getRechargeOrderNo(oldRechargeNo);
                rechargeService.insertTByKey(newRechargeNo,accountNo,3,money,2);
                //
                //存储 金额
                //订单 充值
                resultView.setStatus(StatusConfig.SUCCESS);
                resultView.setMessage("充值成功！");
            }else {
                resultView.setStatus(StatusConfig.FAIL);
                resultView.setMessage("充值失败！");
            }
        }else {
            resultView.setStatus(StatusConfig.FAIL);
            resultView.setMessage("充值错误！");
        }
        return resultView;
    }

    @RequestMapping(value = "/uploadFileIDCard")
    public ResultView uploadFileIDCard(@RequestParam("frontFaceFile") MultipartFile file,
                                   @RequestParam("reverseFaceFile") MultipartFile file1,
                                   @RequestParam("handheldFaceFile") MultipartFile file2,
                                   @RequestParam("realName") String realName,
                                   @RequestParam("IdNumber") String IdNumber,
                                   @RequestParam("uid") String uid){
        resultView = new ResultView();
        reMap = new HashMap<String, Object>();
        if(file != null && file1 != null && file2 != null && IdNumber != null && realName != null){
            if(!REVUtils.IsIDcard(IdNumber) || !REVUtils.isChinese(realName)){
                resultView.setStatus(StatusConfig.FAIL);
                resultView.setMessage("用户认证信息错误！");
                return resultView;
            }
            //设置前缀
            String accountNo = redisService.select(uid);
            if(!userService.selectCertificationByANO(accountNo)){//判断 是否 已有 验证
                //文件名
                String fileName = file.getOriginalFilename();
                //获取后缀
                String suffixName = fileName.substring(fileName.lastIndexOf("."));
                //获取原 fileNo
                String oldNo = fileURLService.selectTByAuto();
                //获取文件URL
                String fileNo = AutoIncUtils.getFileURLNo(oldNo);
                //设置路径
                String filePath = FileConfig.BASICPATH + FileConfig.PSONLPATH + accountNo +"\\";
                //上传文件 名
                String newFileName = fileNo + suffixName;
                //存放路径
                String fileURL = filePath + newFileName;
                String fileURL1 = fileURL;
                //上传 文件
                if(UploadUtils.uploadFile(file,filePath,newFileName)) {
                    //存入 公共 文件 表
                    fileURLService.insertTByKey(fileNo,fileURL1,accountNo);
                    //获取文件2
                    fileName = file1.getOriginalFilename();
                    suffixName = fileName.substring(fileName.lastIndexOf("."));
                    oldNo = fileURLService.selectTByAuto();
                    fileNo = AutoIncUtils.getFileURLNo(oldNo);
                    newFileName = fileNo + suffixName;
                    String fileURL2 = filePath + newFileName;
                    if(UploadUtils.uploadFile(file1,filePath,newFileName)){
                        fileURLService.insertTByKey(fileNo,fileURL2,accountNo);
                        //获取文件3
                        fileName = file2.getOriginalFilename();
                        suffixName = fileName.substring(fileName.lastIndexOf("."));
                        oldNo = fileURLService.selectTByAuto();
                        fileNo = AutoIncUtils.getFileURLNo(oldNo);
                        newFileName = fileNo + suffixName;
                        String fileURL3 = filePath + newFileName;
                        if(UploadUtils.uploadFile(file2,filePath,newFileName)){
                            fileURLService.insertTByKey(fileNo,fileURL3,accountNo);
                            //获取自增 认证No
                            String oleCerNo = certificationService.selectTByAuto();
                            //获取新自增 No
                            String newNo = AutoIncUtils.getCertificationNo(oleCerNo);
                            //存入 认证表
                            certificationService.insertTByKey(newNo,accountNo,realName,IdNumber,fileURL1,fileURL2,fileURL3);
                            accountService.updateCertificationByANO(1,accountNo);
                            //设置返回 数据
                            //reMap.put("")
                            resultView.setStatus(StatusConfig.SUCCESS);
                            resultView.setMessage("文件上传成功！");
                        }else{
                            resultView.setStatus(StatusConfig.FAIL);
                            resultView.setMessage("文件上传失败3！");
                        }
                    }else{
                        resultView.setStatus(StatusConfig.FAIL);
                        resultView.setMessage("文件上传失败2！");
                    }
                }else{
                    resultView.setStatus(StatusConfig.FAIL);
                    resultView.setMessage("文件上传失败1！");
                }
            }else{
                resultView.setStatus(StatusConfig.FAIL);
                resultView.setMessage("用户已经认证！");
            }
        }else{
            resultView.setStatus(StatusConfig.FAIL);
            resultView.setMessage("文件上传错误！");
        }
        return resultView;
    }
    @RequestMapping(value = "/checkCellphoneCode")
    public ResultView checkCellphoneCode(@RequestParam("code") String code, @RequestParam("uid") String uid) {
        resultView = new ResultView();
        String accountNo = redisService.select(uid);
        if(accountNo != null && code != null) {
            if(REVUtils.isLogonInfo(code) && redisService.exist(accountNo)){
                if(redisService.exist(redisService.select(accountNo))){
                    if(redisService.select(redisService.select(accountNo)).equals(code)){
                        String cellphone = redisService.select(accountNo);
                        redisService.drop(redisService.select(accountNo));
                        redisService.drop(accountNo);
                        //update cellphone
                        userService.updateCPByCPANo(cellphone,accountNo);
                        resultView.setStatus(StatusConfig.SUCCESS);
                        resultView.setMessage("换绑手机号码成功！");
                    }else {
                        resultView.setStatus(StatusConfig.FAIL);
                        resultView.setMessage("换绑手机号码短信验证失败！");
                    }
                }else {
                    resultView.setStatus(StatusConfig.FAIL);
                    resultView.setMessage("换绑手机号码错误！");
                }
            }else {
                resultView.setStatus(StatusConfig.FAIL);
                resultView.setMessage("换绑手机号码短信验证码错误！");
            }
        }else{
            resultView.setStatus(StatusConfig.FAIL);
            resultView.setMessage("换绑手机号码短信验证失败！");
        }
        return resultView;
    }

    @RequestMapping(value = "sendNewCode")
    public ResultView sendNewCode(@RequestParam("cellphone") String cellphone, @RequestParam("uid") String uid){
        resultView = new ResultView();
        codeResult = new CodeResult();
        smsResult = new SMSResult();
        String accountNo = redisService.select(uid);
        if(accountNo != null && cellphone != null){
            if(REVUtils.isLogonPhone(cellphone) && !userService.selectTByCellPhone(cellphone)){
                if(redisService.exist(accountNo)){
                    redisService.drop(accountNo);
                    codeResult = SMSUtils.cerateMsg(6);//获取信息组合
                    smsResult = SMSUtils.execute(cellphone, codeResult.getMsg());
                    if(smsResult != null && smsResult.getRespCode() != null){
                        if(smsResult.getRespCode().equals(SMSConfig.RESPCODE_SUCCESS)){
                            if(redisService.exist(cellphone)){
                                redisService.drop(cellphone);
                            }
                            redisService.insert(accountNo,cellphone,RedisConfig.REDIS_TIME_30MINUTE);
                            redisService.insert(cellphone,codeResult.getCode(),RedisConfig.REDIS_TIME_30MINUTE);
                            resultView.setStatus(StatusConfig.SUCCESS);
                            resultView.setMessage("换绑手机号码短信验证码,发送成功！");
                        }else{
                            resultView.setStatus(StatusConfig.FAIL);
                            resultView.setMessage("换绑手机号码短信验证码发送频率过快，请稍后再试！");
                        }
                    }else{
                        resultView.setStatus(StatusConfig.FAIL);
                        resultView.setMessage("网络异常,发送验证码失败！");
                    }
                }else {
                    resultView.setStatus(StatusConfig.FAIL);
                    resultView.setMessage("换绑手机号码失败！");
                }
            }else {
                resultView.setStatus(StatusConfig.FAIL);
                resultView.setMessage("换绑手机号码已使用，请更换后再试！");
            }
        }else{
            resultView.setStatus(StatusConfig.FAIL);
            resultView.setMessage("发送换绑手机号码短信验证码失败！");
        }
        return resultView;
    }

    @RequestMapping(value = "/setPayPwd")
    public ResultView setPayPwd(@RequestParam("password") String password, @RequestParam("uid") String uid){
        resultView = new ResultView();
        String accountNo = redisService.select(uid);
        if(accountNo != null && password != null) {
            if(redisService.exist(uid) && redisService.exist(accountNo) && REVUtils.isLogonInfo(password)){
                //更新 密码
                redisService.drop(accountNo);
                accountService.updatePwdByPwdANo(password, accountNo);
                resultView.setStatus(StatusConfig.SUCCESS);
                resultView.setMessage("支付密码修改成功！");
            }else {
                resultView.setStatus(StatusConfig.FAIL);
                resultView.setMessage("支付密码修改失败！");
            }
        }else {
            resultView.setStatus(StatusConfig.FAIL);
            resultView.setMessage("支付密码修改错误！");
        }
        return resultView;
    }

    @RequestMapping(value = "/setNewPwd")
    public ResultView setNewPwd(@RequestParam("password") String password, @RequestParam("uid") String uid){
        resultView = new ResultView();
        String accountNo = redisService.select(uid);
        if(accountNo != null && password != null) {
            if(redisService.exist(uid) && redisService.exist(accountNo) && REVUtils.isLogonInfo(password)){
                //更新 密码
                redisService.drop(accountNo);
                userService.updatePwdByPwdANo(password,accountNo);
                resultView.setStatus(StatusConfig.SUCCESS);
                resultView.setMessage("密码修改成功！");
            }else {
                resultView.setStatus(StatusConfig.FAIL);
                resultView.setMessage("密码修改失败！");
            }
        }else {
            resultView.setStatus(StatusConfig.FAIL);
            resultView.setMessage("密码修改错误！");
        }
        return resultView;
    }

    @RequestMapping(value = "/checkUserCode")
    public ResultView checkUserCode(@RequestParam("code") String code, @RequestParam("uid") String uid) {
        resultView = new ResultView();
        String accountNo = redisService.select(uid);
        if(accountNo != null && code != null) {
            String cellphone = userService.selectCellPhoneByANO(accountNo);
            if(REVUtils.isLogonInfo(code) && redisService.exist(cellphone)){
                if(redisService.select(cellphone).equals(code)){
                    redisService.drop(cellphone);
                    redisService.insert(accountNo,cellphone,RedisConfig.REDIS_TIME_30MINUTE);
                    resultView.setStatus(StatusConfig.SUCCESS);
                    resultView.setMessage("短信验证成功！");
                }else {
                    resultView.setStatus(StatusConfig.FAIL);
                    resultView.setMessage("短信验证失败！");
                }
            }else {
                resultView.setStatus(StatusConfig.FAIL);
                resultView.setMessage("短信验证码错误！");
            }
        }else{
            resultView.setStatus(StatusConfig.FAIL);
            resultView.setMessage("短信验证失败！");
        }
        return resultView;
    }

    @RequestMapping(value = "/sendUserCode")
    public ResultView sendUserCode(@RequestParam("uid") String uid){
        resultView = new ResultView();
        codeResult = new CodeResult();
        smsResult = new SMSResult();
        String accountNo = redisService.select(uid);
        if(accountNo != null){
            String cellphone = userService.selectCellPhoneByANO(accountNo);
            codeResult = SMSUtils.cerateMsg(6);//获取信息组合
            smsResult = SMSUtils.execute(cellphone, codeResult.getMsg());
            if(smsResult != null && smsResult.getRespCode() != null){
                if(smsResult.getRespCode().equals(SMSConfig.RESPCODE_SUCCESS)){
                    if(redisService.exist(cellphone)){
                        redisService.drop(cellphone);
                    }
                    redisService.insert(cellphone,codeResult.getCode(),RedisConfig.REDIS_TIME_30MINUTE);
                    resultView.setStatus(StatusConfig.SUCCESS);
                    resultView.setMessage("短信验证码,发送成功！");
                }else{
                    resultView.setStatus(StatusConfig.FAIL);
                    resultView.setMessage("短信验证码发送频率过快，请稍后再试！");
                }
            }else{
                resultView.setStatus(StatusConfig.FAIL);
                resultView.setMessage("网络异常,发送验证码失败！");
            }
        }else{
            resultView.setStatus(StatusConfig.FAIL);
            resultView.setMessage("发送短信验证码失败！");
        }
        return resultView;
    }

    @RequestMapping(value = "/getUserAutoInfo")
    public ResultView getUserAutoInfo(@RequestParam("uid") String uid){
        resultView = new ResultView();
        accountResult = new AccountResult();
        invlaResultList = new ArrayList<InvlaResult>();
        reMap = new HashMap<String, Object>();
        String accountNo = redisService.select(uid);
        if(accountNo != null){
            //获取个人账户信息
            accountResult = accountService.selectTByANO(accountNo);
            reMap.put("AccountInfo",accountResult);
            //获取个人 消费等 记录
            invlaResultList = invlaService.selectTByANO(accountNo);
            reMap.put("InvlaInfo",invlaResultList);
            if(!reMap.isEmpty()){//返回数据
                resultView.setReMap(reMap);
                resultView.setStatus(StatusConfig.SUCCESS);
                resultView.setMessage("获取个人账户信息成功！");
            }else {
                resultView.setStatus(StatusConfig.FAIL);
                resultView.setMessage("获取个人账户信息为空！");
            }
        }else{
            resultView.setStatus(StatusConfig.FAIL);
            resultView.setMessage("获取个人账户信息失败！");
        }
        return resultView;
    }
}
