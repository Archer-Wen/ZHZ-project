package com.zhzteam.zhz233.service.zlb;

import com.zhzteam.zhz233.model.zlb.AccountResult;

public interface AccountService {
    /**
     * 获取 账户信息
     * @param accountNo
     * @return
     */
    public AccountResult selectTByANO(String accountNo);
    /**
     * 更新 身份验证
     * @param certification
     * @param accountNo
     */
    public void updateCertificationByANO(Integer certification, String accountNo);
    /**
     * 更新 密码
     * @param password
     * @param accountNo
     * @return
     */
    public void updatePwdByPwdANo(String password, String accountNo);
    /**
     * 更新 available
     * @param money
     * @param accountNo
     * @return
     */
    public void updateAvailableByPwdANo(Double money, String accountNo);
}
