package com.spring.cloud.controller;

import com.spring.cloud.service.ConsumeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "/consume", tags = "消费模块")
@RestController
@RequestMapping("/consume")
public class ConsumeController {
    @Autowired
    private ConsumeService consumeService;

    @ApiOperation(httpMethod = "GET",value = "测试Feign调用", notes = "测试Feign调用")
    @RequestMapping(value = "/test/{name}", method = RequestMethod.GET)
    public String testFeign(@PathVariable String name){
        return consumeService.testFeign(name);
    }
}
