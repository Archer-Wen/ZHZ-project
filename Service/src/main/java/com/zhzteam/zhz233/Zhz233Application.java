package com.zhzteam.zhz233;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
@MapperScan("com.zhzteam.zhz233.mapper")
@ComponentScan(basePackages = {"com.zhzteam.zhz233.controller","com.zhzteam.zhz233.service"})
@ServletComponentScan
@EnableCaching //开启缓存
public class Zhz233Application {
    public static void main(String[] args) {
        SpringApplication.run(Zhz233Application.class, args);
    }
}
