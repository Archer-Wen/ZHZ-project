package com.zhzteam.zhz233.common.utils;


import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UploadUtils {

    /**
     * 上传 文件
     * @param file
     * @param filePath
     * @return
     */
    public static Boolean uploadFile(MultipartFile file,String filePath, String fileName){
        if(file != null && filePath != null){
            File cacheFile = new File(filePath,fileName);
            if(!cacheFile.getParentFile().exists() && !cacheFile.getParentFile().isDirectory()){
                cacheFile.getParentFile().mkdirs();
            }
            try {
                file.transferTo(cacheFile);// 文件写入
                return true;
            }catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }else return false;
    }
}
//获取文件名
//String fileName = file.getOriginalFilename();
//System.err.println("文件名：" + fileName);
//String prefixName = fileName.substring(0,fileName.lastIndexOf("."));
// 获取文件的后缀名
//String suffixName = fileName.substring(fileName.lastIndexOf("."));
//System.err.println("文件后缀名：" + suffixName);