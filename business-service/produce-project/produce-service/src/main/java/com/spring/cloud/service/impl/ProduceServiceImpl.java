package com.spring.cloud.service.impl;

import com.spring.cloud.model.command.AddCmd;
import com.spring.cloud.model.dto.AddDTO;
import com.spring.cloud.service.ProduceService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ProduceServiceImpl implements ProduceService {

    @Override
    public String testFeign(String str) {

        if ("nacos".equals(str)) {
            //throw new RuntimeException("nacos 运行异常[test]");
        }
        return "hello: " + str;
    }

    @Override
    public AddDTO testFeign2(AddCmd cmd) {
        if (cmd == null || cmd.getName() == null || "".equals(cmd.getName().trim())) {
            throw new RuntimeException("参数不能为空");
        }
        String id = String.valueOf(new Random().nextInt(100000));
        AddDTO dto = new AddDTO();
        dto.setId(id);
        dto.setName(cmd.getName());
        return dto;
    }
}
