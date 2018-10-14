package com.lp.service;

import com.lp.feign.CityFeignClient;
import com.lp.feign.WeatherDataFeignClient;
import com.lp.vo.Weather;
import com.lp.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private CityFeignClient cityFeignClient;
    @Autowired
    private WeatherDataFeignClient weatherDataFeignClient;

    @Override
    public Weather getDataByCityId(String cityId) {
        //调用微服务
        WeatherResponse weatherResponse = weatherDataFeignClient.getDataByCityId(cityId);
        Weather weather = weatherResponse.getData();
        return weather;
    }

}
