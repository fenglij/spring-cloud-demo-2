package com.spring.cloud.service;

import com.spring.cloud.model.command.TestCmd;
import com.spring.cloud.model.dto.AddDTO;

public interface ConsumeService {

    String testFeign(String str);

    AddDTO testFeign2(TestCmd cmd);
}
