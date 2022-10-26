package com.spring.cloud.api;

import com.spring.boot.cat.config.client.CatFeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "produce-service", configuration = CatFeignConfiguration.class)
public interface ProduceApi {

    @RequestMapping(value = "/testFeign", method = RequestMethod.POST)
    public String testFeign(@RequestParam("str") String str);
}
