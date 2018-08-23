package com.spring.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 统一配置中心测试
 */
@RefreshScope
@RequestMapping("/config")
@RestController
public class ConfigController {

    @Value("${profile}")
    private String profile;

    @RequestMapping("/test")
    public String test(){
        return profile;
    }
}
