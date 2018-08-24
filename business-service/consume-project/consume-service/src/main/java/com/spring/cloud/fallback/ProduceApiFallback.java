package com.spring.cloud.fallback;

import com.spring.cloud.api.ProduceApi;
import com.spring.cloud.service.ConsumeService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 注意如果fallback类直接实现API，会报重复uri重复映射的异常
 * 解决1：fallback类重新定义一个新的RequestMapping，和API定义的不一致即可
 * 解决2：fallback类实现FallbackFactory类
 */
@Component
public class ProduceApiFallback implements FallbackFactory<ProduceApi> {

    @Override
    public ProduceApi create(Throwable throwable) {
        return new ConsumeService() {
            @Override
            public String testFeign(String str) {
                return "method: testFeign() in fallback!";
            }
        };
    }
}
