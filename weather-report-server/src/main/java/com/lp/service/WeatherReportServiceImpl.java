package com.lp.service;

import com.lp.feign.WeatherDataFeignClient;
import com.lp.vo.Weather;
import com.lp.vo.WeatherResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private WeatherDataFeignClient weatherDataFeignClient;

    //当调用getDataByCityId方法失败(服务提供者关闭、调用超时等)时，调用getDataByCityIdFallback方法
    @HystrixCommand(fallbackMethod = "getDataByCityIdFallback")
    @Override
    public Weather getDataByCityId(String cityId) {
        //调用微服务
        WeatherResponse weatherResponse = weatherDataFeignClient.getDataByCityId(cityId);
        Weather weather = weatherResponse.getData();
        return weather;
    }

    //失败回调方法
    public Weather getDataByCityIdFallback(String cityId) {
        Weather weather = new Weather();
        return weather;
    }

}
