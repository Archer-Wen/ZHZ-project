package com.zhzteam.zhz233.mapper.zlb;

import com.zhzteam.zhz233.model.zlb.UserResult;
import org.apache.ibatis.annotations.Param;

public interface CertificationMapper {
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
    public Long insertTByKey(@Param("certificationNo") String certificationNo,
                             @Param("accountNo") String accountNo,
                             @Param("realName") String realName,
                             @Param("IdNumber") String IdNumber,
                             @Param("frontFaceURL") String frontFaceURL,
                             @Param("reverseFaceURL") String reverseFaceURL,
                             @Param("handheldFaceURL") String handheldFaceURL
    );
}
