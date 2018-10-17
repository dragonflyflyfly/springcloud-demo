package com.lp.service;

import com.lp.vo.Weather;

public interface WeatherReportService {

	/**
	 * 根据城市ID查询天气信息
	 */
	Weather getDataByCityId(String cityId);

}
