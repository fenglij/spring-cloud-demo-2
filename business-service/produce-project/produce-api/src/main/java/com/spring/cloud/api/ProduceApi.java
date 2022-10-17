package com.spring.cloud.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "produce-service")
public interface ProduceApi {

    @RequestMapping(value = "/testFeign", method = RequestMethod.POST)
    public String testFeign(@RequestParam("str") String str);
}
