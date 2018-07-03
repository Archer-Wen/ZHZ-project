package com.zhzteam.zhz233.controller.zlb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/zlb/FB")
public class PagesController {

    @RequestMapping("/index")
    @ResponseBody
    public ModelAndView index() {
        return new ModelAndView("FS/index");
    }

    @RequestMapping("/login")
    @ResponseBody
    public ModelAndView login() {
        return new ModelAndView("FS/login");
    }

    @RequestMapping("/error")
    @ResponseBody
    public ModelAndView error() {
        return new ModelAndView("FS/error");
    }

    @RequestMapping("/download")
    @ResponseBody
    public ModelAndView download() {
        return new ModelAndView("FS/download");
    }

    @RequestMapping("/upload")
    @ResponseBody
    public ModelAndView upload() {
        return new ModelAndView("FS/upload");
    }
}