package com.zhzteam.zhz233.service.zlb.impl;

import com.zhzteam.zhz233.mapper.zlb.CertificationMapper;
import com.zhzteam.zhz233.service.zlb.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CertificationServiceImpl implements CertificationService {
    @Autowired
    CertificationMapper certificationMapper;

    @Override
    public String selectTByAuto() {
        return certificationMapper.selectTByAuto();
    }

    @Override
    public Boolean insertTByKey(String certification_no, String accountNo, String realName, String IdNumber, String frontFaceURL, String reverseFaceURL, String handheldFaceURL) {
        if(certificationMapper.insertTByKey(certification_no, accountNo, realName, IdNumber, frontFaceURL, reverseFaceURL, handheldFaceURL) > 0)return true;
        else return false;
    }
}
