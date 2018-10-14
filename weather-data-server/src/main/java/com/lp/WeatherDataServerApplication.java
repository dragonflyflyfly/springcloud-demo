package com.lp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient//将服务注册到eureka注册中心
@SpringBootApplication
public class WeatherDataServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherDataServerApplication.class, args);
    }

}
