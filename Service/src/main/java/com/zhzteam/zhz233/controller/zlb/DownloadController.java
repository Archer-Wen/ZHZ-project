package com.zhzteam.zhz233.controller.zlb;

import com.zhzteam.zhz233.common.utils.DownloadUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/zlb")
public class DownloadController {

    @RequestMapping(value = "/download")
    @ResponseBody
    public String download(HttpServletRequest request, HttpServletResponse response) {
        String pathName =  "G:\\Zhz233File\\";
        String fileName = "UpperDevice2018.05.20.0001.zip";
        if(DownloadUtils.downloadFile(request,response,pathName,fileName)) return "下载成功！";
        else return "下载失败！";
    }
}
