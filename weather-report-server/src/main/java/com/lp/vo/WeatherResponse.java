package com.lp.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Weather Response.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017年11月21日
 */
@Getter
@Setter
public class WeatherResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    private Weather data;
    private Integer status;
    private String desc;

}
