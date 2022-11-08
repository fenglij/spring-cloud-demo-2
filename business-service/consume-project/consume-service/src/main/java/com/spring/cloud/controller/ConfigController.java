package com.spring.cloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 统一配置中心测试
 */
@RefreshScope
@RequestMapping("/config")
@RestController
public class ConfigController {
    private static final Logger log = LoggerFactory.getLogger(ConfigController.class);

    @Value("${test.hello}")
    private String hello;

    @Autowired
    private Environment environment;

    @RequestMapping("/test")
    public String test(){
        return environment.getProperty("profile");
    }

    @RequestMapping("/test/nacos")
    public String testNacos(){
        return hello;
    }

    @RequestMapping("/test/log/{msg}")
    public String testLog(@PathVariable String msg){
        log.info("测试log-spring-boot-starter，日志内容: {}", msg);
        return msg;
    }
}
