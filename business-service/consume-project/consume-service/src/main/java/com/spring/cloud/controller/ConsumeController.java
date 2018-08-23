package com.spring.cloud.controller;

import com.spring.cloud.service.ConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consume")
public class ConsumeController {
    @Autowired
    private ConsumeService consumeService;

    @RequestMapping(value = "/test/{name}", method = RequestMethod.GET)
    public String testFeign(@PathVariable String name){
        return consumeService.testFeign(name);
    }
}
