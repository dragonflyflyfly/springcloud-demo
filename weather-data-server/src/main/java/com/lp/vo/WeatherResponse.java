package com.lp.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherResponse {
    //状态
    private Integer status;
    //描述
    private String desc;
    //数据
    private Weather data;
}
