package com.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

/**
 * springboot2.X 版本已经不建议自行搭建zipkin 服务，
 * 而是提供编译好的jar包直接运行。
 * 如果pom中没有指定 zipkin 版本（2.9.3），
 * 则默认使用springboot2.X的zipkin版本，这个版本是没有@EnableZipkinServer注解的！！！
 * 准确说是zipkin 2.7.X 版本后，@EnableZipkinServer 注解就不再支持了
 */
@SpringBootApplication
@EnableZipkinServer
public class ZipkinServiceApplication {
    public static void main(String[] args){
        SpringApplication.run(ZipkinServiceApplication.class, args);
    }
}
