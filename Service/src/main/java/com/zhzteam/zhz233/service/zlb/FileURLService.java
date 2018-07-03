package com.zhzteam.zhz233.service.zlb;

public interface FileURLService {
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
    public Boolean insertTByKey(String fileNo,String fileURL,String fileTheme);
}
