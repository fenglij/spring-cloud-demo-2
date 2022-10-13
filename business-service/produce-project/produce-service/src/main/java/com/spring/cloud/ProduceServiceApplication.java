package com.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @see https://www.cnblogs.com/xjknight/p/10925123.html
 */
@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class
})
@EnableDiscoveryClient
@EnableFeignClients
public class ProduceServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProduceServiceApplication.class, args);
    }
}
