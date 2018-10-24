package com.lp.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * 天气信息.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017年11月21日
 */
@Getter
@Setter
public class Weather implements Serializable {

    private static final long serialVersionUID = 1L;

    //城市
    private String city;
    //空气质量指数
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
