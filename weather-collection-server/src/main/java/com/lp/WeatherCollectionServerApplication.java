package com.lp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableFeignClients //开启Feign客户端
@EnableScheduling //开启定时任务功能
@EnableDiscoveryClient//将服务注册到eureka注册中心
@SpringBootApplication
public class WeatherCollectionServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherCollectionServerApplication.class, args);
	}

}