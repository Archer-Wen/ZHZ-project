package com.zhzteam.zhz233.common.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class DownloadUtils {

    /**
     * downloadFile文件下载
     * @param request
     * @param response
     * @param pathName
     * @param fileName
     * @return
     */
    public static Boolean downloadFile(HttpServletRequest request, HttpServletResponse response,String pathName,String fileName){
        //pathName =  "G:\\Zhz233File\\";
        //fileName = "UpperDevice2018.05.20.0001.exe";
        if(pathName != null && fileName != null){
            File file = new File(pathName, fileName);
            if(file.exists()){
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition",
                        "attachment;fileName=" +  fileName);// 设置文件名
                response.setCharacterEncoding("UTF-8");
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }
                return true;
            }else return false;
        }else return false;
    }
}
