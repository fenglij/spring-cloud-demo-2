package com.spring.cloud.service;

import com.spring.cloud.api.ProduceApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("produce-service")
public interface ConsumeService extends ProduceApi {
}
