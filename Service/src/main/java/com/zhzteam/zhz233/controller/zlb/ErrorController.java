package com.zhzteam.zhz233.controller.zlb;

import com.zhzteam.zhz233.common.config.StatusConfig;
import com.zhzteam.zhz233.model.zlb.PathResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/zlb")
public class ErrorController {

    @RequestMapping("/errors")
    public PathResult login(){
        PathResult pathResult = new PathResult();
        pathResult.setPath("/error");
        pathResult.setStatus(StatusConfig.SUCCESS);
        return pathResult;
    }
}
