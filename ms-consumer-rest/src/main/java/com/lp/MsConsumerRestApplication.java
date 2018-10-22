package com.lp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsConsumerRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsConsumerRestApplication.class, args);
	}

}
