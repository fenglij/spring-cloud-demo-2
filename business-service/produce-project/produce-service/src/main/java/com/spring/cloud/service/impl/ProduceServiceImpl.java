package com.spring.cloud.service.impl;

import com.spring.cloud.service.ProduceService;
import org.springframework.stereotype.Service;

@Service
public class ProduceServiceImpl implements ProduceService {

    @Override
    public String testFeign(String str) {
        return "hello: " + str;
    }
}
