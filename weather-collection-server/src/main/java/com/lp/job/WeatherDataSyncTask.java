package com.lp.job;

import com.lp.feign.CityFeignClient;
import com.lp.service.WeatherDataCollectionService;
import com.lp.vo.City;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 方式一：Spring的简单任务方式(【我的实现】)
 */
@Slf4j
@Component
public class WeatherDataSyncTask {

    @Autowired
    private WeatherDataCollectionService weatherDataCollectionService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /*@Autowired
    private RestTemplate restTemplate;*/

    @Autowired
    private CityFeignClient cityFeignClient;

    @Scheduled(fixedRate = 30000)//每30秒执行一次
    //@Scheduled(fixedRate = 600000)//每10min执行一次
    public void syncDateToCache() {
        log.info("Weather Data Sync Job. Start！");

        List<City> cityList = null;
        try {
            // 方式一：RestTemplate调用

            // 方式二：Feign调用
            cityList = cityFeignClient.listCity();
        } catch (Exception e) {
            log.error("Exception!", e);
        }

        // 遍历城市ID获取天气
        for (City city : cityList) {
            String cityId = city.getCityId();
            log.info("Weather Data Sync Job, cityId:" + cityId);

            weatherDataCollectionService.syncDateByCityId(cityId);
        }

        log.info("Weather Data Sync Job. End！");
    }

}