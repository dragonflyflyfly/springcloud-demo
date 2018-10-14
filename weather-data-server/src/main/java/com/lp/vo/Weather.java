package com.lp.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Weather {
    //城市
    private String city;

    private String aqi;
    //感冒
    private String ganmao;
    //温度
    private String wendu;
    //昨日天气
    private Yeaterday yesterday;
    //未来天气
    private List<Forecast> forecast;

}
