package com.lp.controller;

import com.lp.domain.User;
import com.lp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    User getUserById(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }




/*    @Value("${demo}")
    private String demo;

    @GetMapping("/hello")
    public String hello() {
        return this.demo;
    }*/

}
