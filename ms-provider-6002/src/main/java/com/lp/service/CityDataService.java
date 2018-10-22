package com.lp.service;


import com.lp.vo.City;

import java.util.List;

public interface CityDataService {

    List<City> listCity() throws Exception;

    City getCityById(Integer id) throws Exception;

    City getCityByName(String name) throws Exception;

}
