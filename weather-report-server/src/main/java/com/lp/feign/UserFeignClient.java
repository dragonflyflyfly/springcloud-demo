package com.lp.feign;

import com.lp.vo.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "weather-user-server")
public interface UserFeignClient {

    @GetMapping("/user/{id}")
    User getUserById(@PathVariable("id") Integer id);

}
