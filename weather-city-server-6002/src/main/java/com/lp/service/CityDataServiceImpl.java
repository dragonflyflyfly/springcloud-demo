package com.lp.service;

import com.lp.util.XmlBuilder;
import com.lp.vo.City;
import com.lp.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class CityDataServiceImpl implements CityDataService {

    @Override
    public List<City> listCity() throws Exception {
        return doListCity();
    }

    @Override
    public City getCityById(Integer id) throws Exception {
        List<City> cityList = doListCity();
        for (City city : cityList) {
            if (city.getCityId().equals(String.valueOf(id))) {
                return city;
            }
        }
        return null;
    }

    @Override
    public City getCityByName(String name) throws Exception {
        List<City> cityList = doListCity();
        for (City city : cityList) {
            if (city.getCityName().equals(name)) {
                return city;
            }
        }
        return null;
    }

    private List<City> doListCity() throws Exception {
        // 读取XML文件
        Resource resource = new ClassPathResource("citylist.xml");
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));
        StringBuffer buffer = new StringBuffer();
        String line = "";

        while ((line = br.readLine()) != null) {
            buffer.append(line);
        }

        br.close();

        // XML转为Java对象
        CityList cityList = (CityList) XmlBuilder.xmlStrToOject(CityList.class, buffer.toString());
        return cityList.getCityList();
    }

}
