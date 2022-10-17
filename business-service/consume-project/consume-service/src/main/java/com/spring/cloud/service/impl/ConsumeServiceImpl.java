package com.spring.cloud.service.impl;

import com.spring.cloud.api.ProduceApi;
import com.spring.cloud.feign.ProduceClientApi;
import com.spring.cloud.service.ConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fenglijian
 * @date 2022-10-13 18:36
 */
@Service
public class ConsumeServiceImpl implements ConsumeService {

    @Autowired
    private ProduceClientApi produceClientApi;

    public String testFeign(String str) {
        String s = produceClientApi.testFeign(str);
        return s;
    }
}
