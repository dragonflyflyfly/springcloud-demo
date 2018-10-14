package com.lp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

//启用网关服务。该zuul代理使用Ribbon来定位注册在Eureka中的微服务。
@EnableZuulProxy// 同时该代理还整合了Hystrix来实现容错，所有经过zuul的请求都会在Hystrix命令中执行。
@EnableDiscoveryClient //网关服务也需要注册到注册中心
@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

}
