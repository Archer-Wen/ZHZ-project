package com.zhzteam.zhz233.service.zlb.impl;

import com.zhzteam.zhz233.mapper.zlb.FileURLMapper;
import com.zhzteam.zhz233.service.zlb.FileURLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileURLServiceImpl implements FileURLService {

    @Autowired
    FileURLMapper fileURLMapper;

    @Override
    public String selectTByAuto() {
        return fileURLMapper.selectTByAuto();
    }

    @Override
    public Boolean insertTByKey(String fileNo, String fileURL, String fileTheme) {
        if(fileURLMapper.insertTByKey(fileNo, fileURL, fileTheme) > 0) return true;
        else return false;
    }
}
