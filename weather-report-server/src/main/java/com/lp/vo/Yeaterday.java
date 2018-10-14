package com.lp.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 昨日天气.
 * 
 * @since 1.0.0 2017年11月21日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
@Getter
@Setter
public class Yeaterday implements Serializable {
	private static final long serialVersionUID = 1L;
	private String date;
	private String high;
	private String fx;
	private String low;
	private String fl;
	private String type;
}
