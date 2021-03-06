package com.spring.cloud.controller;

import com.spring.cloud.api.ProduceApi;
import com.spring.cloud.service.ProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produce-service")
public class ProduceController implements ProduceApi {

    @Autowired
    private ProduceService produceService;

    @RequestMapping(value = "/testFeign", method = RequestMethod.POST)
    @Override
    public String testFeign(@RequestParam("str") String str) {
        return produceService.testFeign(str);
    }
}
