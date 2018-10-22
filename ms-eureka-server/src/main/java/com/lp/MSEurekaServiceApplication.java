package com.lp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer//声明注册中心，使用Eureka做服务发现
@SpringBootApplication
public class MSEurekaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MSEurekaServiceApplication.class, args);
    }

}