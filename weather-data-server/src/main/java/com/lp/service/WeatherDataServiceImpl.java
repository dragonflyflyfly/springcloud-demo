package com.lp.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lp.feign.CityFeignClient;
import com.lp.vo.City;
import com.lp.vo.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private CityFeignClient cityFeignClient;

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        return doGetWeather(uri);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        //原方式：按城市id和城市名在redis中分别存了一份，完全没别要。
        //String uri = WEATHER_URI + "city=" + cityName;

        //我修改：城市微服务中提供接口(将cityName转cityId)，仍然使用cityId来获取数据。
        City city = cityFeignClient.getCityByName(cityName);

        String uri = WEATHER_URI + "citykey=" + city.getCityId();
        return doGetWeather(uri);
    }

    private WeatherResponse doGetWeather(String uri) {
        String key = uri;
        String value = null;
        //查redis缓存
        if (stringRedisTemplate.hasKey(key)) {
            ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
            value = ops.get(key);
        } else {
            //redis无数据，抛出异常
            throw new RuntimeException("Don't has data!");
        }

        WeatherResponse response = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            //属性为NULL不序列化
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            response = mapper.readValue(value, WeatherResponse.class);
        } catch (IOException e) {
            //e.printStackTrace();
            log.error("Error!", e);
        }

        return response;
    }

}
