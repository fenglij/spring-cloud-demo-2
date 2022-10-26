package com.spring.cloud.service.impl;

import com.spring.cloud.service.ProduceService;
import org.springframework.stereotype.Service;

@Service
public class ProduceServiceImpl implements ProduceService {

    @Override
    public String testFeign(String str) {

        if ("nacos".equals(str)) {
            throw new RuntimeException("nacos 运行异常[test]");
        }
        return "hello: " + str;
    }
}
