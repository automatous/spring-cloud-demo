package com.example.demo.controller;

import com.example.demo.config.CloudConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RefreshScope
@RestController
public class MyController {

//    @Resource
//    CloudConfig cloudConfig;

    @Value("${stuname}")
    private String stuname;

//    @RequestMapping("/foo")
//    public String foo() {
//        return "foo return stuname: " + cloudConfig.getStuname();
//    }

    @RequestMapping("/foo")
    public String foo() {
        return "foo return stuname: " + stuname;
    }
}
