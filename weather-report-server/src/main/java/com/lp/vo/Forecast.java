package com.lp.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 未来天气.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017年11月21日
 */
@Getter
@Setter
public class Forecast implements Serializable {

    private static final long serialVersionUID = 1L;
    private String date; //时间
    private String high; //高温
    private String fengli; //风力
    private String low; //低温
    private String fengxiang; //风向
    private String type; //多云等

}
