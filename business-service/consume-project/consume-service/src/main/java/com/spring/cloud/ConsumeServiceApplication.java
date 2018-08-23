package com.spring.cloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
@EnableDiscoveryClient
@EnableFeignClients
public class ConsumeServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumeServiceApplication.class, args);
    }
}
