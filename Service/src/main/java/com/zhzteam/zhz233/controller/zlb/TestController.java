package com.zhzteam.zhz233.controller.zlb;

import com.zhzteam.zhz233.common.utils.UploadUtils;
import com.zhzteam.zhz233.model.TestModel;
import com.zhzteam.zhz233.service.zlb.impl.RedisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    RedisServiceImpl redisService;

    @RequestMapping("/uploadFile")
    public String createFile(){
        String baseFilePath = "G:\\Zhz233File\\";
        String newPath = "newFile\\";
        File file = new File(baseFilePath + newPath);



        if(!file.exists()){
            file.mkdirs();
        }
        return "success";
    }

    @RequestMapping("/redis")
    public String redisTest(){
        TestModel testModel = new TestModel();
        testModel.setTest("test");
        redisService.set("test",testModel,1000L);
        System.err.println(testModel.getTest()+"/////");
        testModel = (TestModel) redisService.get("test");
        System.err.println(testModel.getTest());
        return "test";
    }
}
