package com.spring.cloud.service;

import com.spring.cloud.api.ProduceApi;
import com.spring.cloud.fallback.ProduceApiFallback;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "produce-service", fallbackFactory = ProduceApiFallback.class)
public interface ConsumeService extends ProduceApi {
}
