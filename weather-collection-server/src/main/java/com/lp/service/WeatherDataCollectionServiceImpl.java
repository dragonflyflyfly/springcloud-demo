package com.lp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";
    private static final long TIME_OUT = 1800L; // 1800s

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 将采集的天气数据缓存到redis
     */
    @Override
    public void syncDateByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        // 【调用第三方服务】
        ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);

        String strBody = null;
        if (respString.getStatusCodeValue() == 200) {
            strBody = respString.getBody();
        }

        // 数据写入redis缓存
        String key = uri;
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        //ops.set(key, strBody, TIME_OUT, TimeUnit.SECONDS);
        ops.set(key, strBody);
    }
}
