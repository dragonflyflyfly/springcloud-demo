package com.lp.feign;

import com.lp.vo.City;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "weather-city-server")
public interface CityFeignClient {

    @GetMapping("/city/cityName/{cityName}")
    City getCityByName(@PathVariable("cityName") String cityName);

}
