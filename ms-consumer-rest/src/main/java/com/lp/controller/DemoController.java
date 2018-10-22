package com.lp.controller;

import com.lp.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DemoController {

    private final static String CITY_URI = "http://ms-provider";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/cities")
    public List<City> getCity() throws Exception {
        String uri = CITY_URI + "/cities";
        return restTemplate.getForObject(uri, List.class);
    }

    @GetMapping("/city/cityId/{cityId}")
    public City getCityById(@PathVariable("cityId") Integer cityId) throws Exception {
        String uri = CITY_URI + "/city/cityId/" + cityId;
        return restTemplate.getForObject(uri, City.class);
    }

    @GetMapping("/city/cityName/{cityName}")
    public City getCityByName(@PathVariable("cityName") String cityName) throws Exception {
        String uri = CITY_URI + "/city/cityName/" + cityName;
        return restTemplate.getForObject(uri, City.class);
    }

}
