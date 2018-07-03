package com.zhzteam.zhz233.service.zlb.impl;

import com.zhzteam.zhz233.mapper.zlb.AccountMapper;
import com.zhzteam.zhz233.model.zlb.AccountResult;
import com.zhzteam.zhz233.service.zlb.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountMapper accountMapper;

    @Override
    public AccountResult selectTByANO(String accountNo) {
        return accountMapper.selectTByANO(accountNo);
    }

    @Override
    public void updateCertificationByANO(Integer certification, String accountNo) {
        accountMapper.updateCertificationByANO(certification,accountNo);
    }

    @Override
    public void updatePwdByPwdANo(String password, String accountNo) {
        accountMapper.updatePwdByPwdANo(password, accountNo);
    }

    @Override
    public void updateAvailableByPwdANo(Double money, String accountNo) {
        accountMapper.updateAvailableByPwdANo(money, accountNo);
    }
}
