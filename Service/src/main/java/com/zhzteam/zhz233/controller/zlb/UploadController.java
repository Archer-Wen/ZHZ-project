package com.zhzteam.zhz233.controller.zlb;

import com.zhzteam.zhz233.common.config.FileConfig;
import com.zhzteam.zhz233.common.config.StatusConfig;
import com.zhzteam.zhz233.common.utils.AutoIncUtils;
import com.zhzteam.zhz233.common.utils.UploadUtils;
import com.zhzteam.zhz233.model.zlb.ResultView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
@RequestMapping(value = "/zlb")
public class UploadController {

    private ResultView resultView;

    @RequestMapping(value = "/upload")
    public ResultView ResultView(@RequestParam("file") MultipartFile file){
        //初始化容器
        resultView = new ResultView();
        if(!file.isEmpty()){
            String fileName = file.getOriginalFilename();
            //获取后缀
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            //设置前缀
            String prefixName = FileConfig.BASICPATH + FileConfig.PSONLPATH;
            //获取原 fileNo
            String oldNo = "";
            //获取文件URL
            String fileNo = AutoIncUtils.getFileURLNo(oldNo);
            //设置路径
            String filePath = FileConfig.BASICPATH + FileConfig.PSONLPATH;
            //上传文件
            UploadUtils.uploadFile(file,filePath,"1221.zip");
        }else{
            resultView.setStatus(StatusConfig.FAIL);
            resultView.setMessage("文件为空!");
        }
        return resultView;
    }
}
