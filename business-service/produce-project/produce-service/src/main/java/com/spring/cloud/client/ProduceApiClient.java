package com.spring.cloud.client;

import com.spring.cloud.api.ProduceApi;
import com.spring.cloud.model.command.AddCmd;
import com.spring.cloud.model.dto.AddDTO;
import com.spring.cloud.service.ProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class ProduceApiClient implements ProduceApi {

    @Autowired
    private ProduceService produceService;

    @Override
    public String testFeign(String str) {
        return produceService.testFeign(str);
    }

    @Override
    public AddDTO testFeign2(AddCmd cmd) {
        return produceService.testFeign2(cmd);
    }
}
