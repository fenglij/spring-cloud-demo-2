package com.spring.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * sentinel测试
 */
@RefreshScope
@RequestMapping("/sentinel")
@RestController
public class SentinelController {

    @Autowired
    private Environment environment;

    @RequestMapping("/env")
    public String test(){
        return environment.getProperty("profile")+": aaaa";
    }

    @SentinelResource("test")
    @RequestMapping("/test/{hello}")
    public String testNacos(@PathVariable String hello){
        // 配置在启动参数
        return hello + ", " + environment.getProperty("csp.sentinel.dashboard.server");
    }
}
