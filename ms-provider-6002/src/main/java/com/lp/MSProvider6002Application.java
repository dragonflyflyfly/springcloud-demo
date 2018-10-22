package com.lp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient//将服务注册到eureka注册中心
@SpringBootApplication
public class MSProvider6002Application {

	public static void main(String[] args) {
		SpringApplication.run(MSProvider6002Application.class, args);
	}

}
