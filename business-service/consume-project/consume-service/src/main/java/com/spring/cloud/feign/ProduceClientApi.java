package com.spring.cloud.feign;

import com.spring.cloud.api.ProduceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 防腐层
 * feign 客户端
 * @author fenglijian
 * @date 2022-10-17 16:14
 */
@Component
public class ProduceClientApi {
    @Autowired
    private ProduceApi produceApi;

    public String testFeign(String str) {
        String s = produceApi.testFeign(str);
        return s;
    }
}
