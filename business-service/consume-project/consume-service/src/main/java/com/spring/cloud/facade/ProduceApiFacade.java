package com.spring.cloud.facade;

import com.spring.cloud.api.ProduceApi;
import com.spring.cloud.model.command.AddCmd;
import com.spring.cloud.model.dto.AddDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 防腐层
 * feign 客户端
 * @author fenglijian
 * @date 2022-10-17 16:14
 */
@Component
public class ProduceApiFacade {
    @Autowired
    private ProduceApi produceApi;

    public String testFeign(String str) {
        String s = produceApi.testFeign(str);
        return s;
    }

    public AddDTO testFeign2(AddCmd cmd) {
        AddDTO dto = produceApi.testFeign2(cmd);
        return dto;
    }
}
