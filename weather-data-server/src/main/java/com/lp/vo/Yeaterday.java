package com.lp.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * 昨日天气
 */
@Getter
@Setter
public class Yeaterday {
    //日期
    private String date;
    //最高温
    private String high;
    //风向
    private String fx;
    //最低温
    private String low;
    //风力
    private String fl;
    //天气类型:小雨、多云等等
    private String type;
}
