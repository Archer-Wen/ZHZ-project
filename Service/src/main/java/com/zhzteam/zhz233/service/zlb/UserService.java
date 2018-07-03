package com.zhzteam.zhz233.service.zlb;

import com.zhzteam.zhz233.model.zlb.UserResult;

public interface UserService {

    /**
     * 判断 用户名 密码 是否有效
     * @param username
     * @param password
     * @return
     */
    public UserResult selectTByKey(String username, String password);

    /**
     * 添加 用户信息 是否有效 返回 UserResult
     * @param username
     * @param cellphone
     * @param password
     * @param autoNo
     * @return
     */
    public Boolean insertTByKey(String username,String cellphone,String password,String autoNo);
    /**
     * 查询 username
     * @param username
     * @return
     */
    public Boolean selectTByUserName(String username);
    /**
     * 查询 cellphone
     * @param cellphone
     * @return
     */
    public Boolean selectTByCellPhone(String cellphone);
    /**
     * 获取自增 NO
     * @return
     */
    public String selectTByAuto();
    /**
     * 获取 UserResult
     * @param no
     * @return
     */
    public UserResult selectTByNo(String no);
    /**
     * 获取用户 手机号
     * @param accountNo
     * @return
     */
    public String selectCellPhoneByANO(String accountNo);
    /**
     * 更新 密码
     * @param password
     * @param accountNo
     * @return
     */
    public void updatePwdByPwdANo(String password, String accountNo);
    /**
     * 更新 手机号
     * @param cellphone
     * @param accountNo
     */
    public void updateCPByCPANo(String cellphone, String accountNo);
    /**
     * 获取用户 认证状态
     * @param accountNo
     * @return
     */
    public Boolean selectCertificationByANO(String accountNo);
}
