package com.lp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer //开启配置服务
@EnableDiscoveryClient
@SpringBootApplication
public class MSConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MSConfigServerApplication.class, args);
	}
}
