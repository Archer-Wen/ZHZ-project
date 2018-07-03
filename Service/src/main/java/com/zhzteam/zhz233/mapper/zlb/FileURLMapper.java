package com.zhzteam.zhz233.mapper.zlb;

import org.apache.ibatis.annotations.Param;

public interface FileURLMapper {
    /**
     * 获取自增 NO
     * @return
     */
    public String selectTByAuto();

    /**
     * 添加 文件
     * @param fileNo
     * @param fileURL
     * @param fileTheme
     */
    public Long insertTByKey(@Param("fileNo") String fileNo,
                             @Param("fileURL") String fileURL,
                             @Param("fileTheme") String fileTheme);
}
