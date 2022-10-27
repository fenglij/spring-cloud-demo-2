package com.spring.cloud.controller;

import com.spring.cloud.base.Result;
import com.spring.cloud.base.ResultUtil;
import com.spring.cloud.model.command.TestCmd;
import com.spring.cloud.model.dto.AddDTO;
import com.spring.cloud.service.ConsumeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "/consume", tags = "消费模块")
@RestController
@RequestMapping("/consume")
public class ConsumeController {
    @Autowired
    private ConsumeService consumeService;

    @ApiOperation(httpMethod = "GET",value = "测试Feign调用", notes = "测试Feign调用")
    @RequestMapping(value = "/test/{name}", method = RequestMethod.GET)
    public Result testFeign(@PathVariable String name) {
        String text = consumeService.testFeign(name);
        return ResultUtil.success(text);
    }

    @ApiOperation(httpMethod = "POST",value = "测试Feign调用", notes = "测试Feign调用")
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public Result testFeign2(@RequestBody TestCmd cmd) {
        AddDTO dto = consumeService.testFeign2(cmd);
        return ResultUtil.success(dto);
    }
}
