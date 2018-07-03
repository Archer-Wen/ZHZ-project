package com.zhzteam.zhz233.service.zlb;

public interface CertificationService {
    /**
     * 获取自增 NO
     * @return
     */
    public String selectTByAuto();
    /**
     * 添加 认证信息
     * @param certification_no
     * @param accountNo
     * @param realName
     * @param IdNumber
     * @param frontFaceURL
     * @param reverseFaceURL
     * @param handheldFaceURL
     */
    public Boolean insertTByKey(String certification_no,String accountNo,String realName,
                             String IdNumber,String frontFaceURL,String reverseFaceURL,
                             String handheldFaceURL
    );
}
