package com.lp;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@SpringCloudApplication//该注解能替代下面三个注解
//@EnableCircuitBreaker //启动断路器
//@EnableDiscoveryClient//将服务注册到eureka注册中心
//@SpringBootApplication
public class WeatherReportServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherReportServerApplication.class, args);
	}

}