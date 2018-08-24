package com.spring.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 统一配置中心测试
 */
@RefreshScope
@RequestMapping("/config")
@RestController
public class ConfigController {


//    @Value("${profile}")
//    private String profile;

    @Autowired
    private Environment environment;

    @RequestMapping("/test")
    public String test(){

        //return profile;
        return environment.getProperty("profile");
    }
}
