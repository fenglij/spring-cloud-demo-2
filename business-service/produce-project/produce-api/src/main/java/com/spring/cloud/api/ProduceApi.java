package com.spring.cloud.api;

import com.spring.boot.cat.config.client.CatFeignConfiguration;
import com.spring.cloud.model.command.AddCmd;
import com.spring.cloud.model.dto.AddDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "produce-service", configuration = CatFeignConfiguration.class)
public interface ProduceApi {

    @RequestMapping(value = "/testFeign", method = RequestMethod.POST)
    String testFeign(@RequestParam("str") String str);

    @RequestMapping(value = "/testFeign2", method = RequestMethod.POST)
    AddDTO testFeign2(@RequestBody AddCmd cmd);
}
