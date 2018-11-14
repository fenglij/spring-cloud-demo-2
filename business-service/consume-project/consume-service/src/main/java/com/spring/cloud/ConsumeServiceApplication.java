package com.spring.cloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * exclude: 禁用指定的自动化配置来避免加载不必要的自动化配置
 * 比如不需要加载数据源. 则 exclude: DataSourceAutoConfiguration.class
 */
@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        DataSourceAutoConfiguration.class
})
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
public class ConsumeServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumeServiceApplication.class, args);
    }
}
