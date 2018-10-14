package com.lp.controller;

import com.lp.service.CityDataService;
import com.lp.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityController {

    @Autowired
    private CityDataService cityDataService;

    /**
     * 所有城市列表
     */
    @GetMapping("/cities")
    public List<City> listCity() throws Exception {
        return cityDataService.listCity();
    }

    /**
     * 根据城市id获取城市
     */
    @GetMapping("/city/cityId/{cityId}")
    public City getCityById(@PathVariable("cityId") Integer cityId) throws Exception {
        System.out.println(cityDataService.getCityById(cityId));
        return cityDataService.getCityById(cityId);
    }

    /**
     * 根据城市名获取城市
     */
    @GetMapping("/city/cityName/{cityName}")
    public City getCityByName(@PathVariable("cityName") String cityName) throws Exception {
        return cityDataService.getCityByName(cityName);
    }

}