package com.lp.service;

public interface WeatherDataCollectionService {

    /**
     * 根据城市ID同步天气
     */
    void syncDateByCityId(String cityId);

}
