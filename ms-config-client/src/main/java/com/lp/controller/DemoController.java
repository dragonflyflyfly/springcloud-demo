package com.lp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope //这里的@RefreshScope注解不能少，否则即使调用/refresh，配置也不会刷新
@RestController
public class DemoController {

    @Value("${demo}")
    private String demo;

    @GetMapping("/hello")
    public String hello() {
        return this.demo;
    }

}
