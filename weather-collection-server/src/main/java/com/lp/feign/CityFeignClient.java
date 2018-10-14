package com.lp.feign;

import com.lp.vo.City;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 使用Feign来调用city服务
 */
@FeignClient(name = "weather-city-server")
public interface CityFeignClient {

    @GetMapping("/cities")
    List<City> listCity();

}
