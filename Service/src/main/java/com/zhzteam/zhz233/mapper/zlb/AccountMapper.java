package com.zhzteam.zhz233.mapper.zlb;

import com.zhzteam.zhz233.model.zlb.AccountResult;
import org.apache.ibatis.annotations.Param;

public interface AccountMapper {
    /**
     * 获取 账户信息
     * @param accountNo
     * @return
     */
    public AccountResult selectTByANO(@Param("accountNo") String accountNo);

    /**
     * 更新 身份验证
     * @param certification
     * @param accountNo
     */
    public void updateCertificationByANO(@Param("certification") Integer certification,@Param("accountNo") String accountNo);

    /**
     * 更新 密码
     * @param password
     * @param accountNo
     * @return
     */
    public void updatePwdByPwdANo(@Param("password") String password,@Param("accountNo") String accountNo);
    /**
     * 更新 available
     * @param money
     * @param accountNo
     * @return
     */
    public void updateAvailableByPwdANo(@Param("money") Double money,@Param("accountNo") String accountNo);
}
