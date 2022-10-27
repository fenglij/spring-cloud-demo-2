package com.spring.cloud.service;

import com.spring.cloud.model.command.AddCmd;
import com.spring.cloud.model.dto.AddDTO;

public interface ProduceService {

    String testFeign(String name);

    AddDTO testFeign2(AddCmd cmd);
}
