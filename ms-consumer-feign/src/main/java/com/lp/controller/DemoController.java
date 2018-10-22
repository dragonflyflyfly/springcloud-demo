package com.lp.controller;

import com.lp.feign.CityFeignClient;
import com.lp.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    @Autowired
    private CityFeignClient cityFeignClient;

    @GetMapping("/cities")
    public List<City> getCity() throws Exception {
        return cityFeignClient.listCity();
    }


    @GetMapping("/city/cityId/{cityId}")
    public City getCityById(@PathVariable("cityId") Integer cityId) throws Exception {
        return cityFeignClient.getCityById(cityId);
    }

    @GetMapping("/city/cityName/{cityName}")
    public City getCityByName(@PathVariable("cityName") String cityName) throws Exception {
        return cityFeignClient.getCityByName(cityName);
    }

}
