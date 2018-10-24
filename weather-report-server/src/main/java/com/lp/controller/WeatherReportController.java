package com.lp.controller;

import com.lp.feign.CityFeignClient;
import com.lp.feign.UserFeignClient;
import com.lp.service.WeatherReportService;
import com.lp.vo.City;
import com.lp.vo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class WeatherReportController {
    private final static Logger logger = LoggerFactory.getLogger(WeatherReportController.class);

    @Autowired
    private WeatherReportService weatherReportService;
    @Autowired
    private CityFeignClient cityFeignClient;
    @Autowired
    private UserFeignClient userFeignClient;

    /*****************************根据城市获取天气************************/
    @GetMapping("/report/cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception {
        model.addAttribute("title", "我的天气预报");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", getCityList());
        model.addAttribute("report", weatherReportService.getDataByCityId(cityId));

        return new ModelAndView("weather/report", "reportModel", model);
    }

    /*****************************根据用户获取天气************************/
    @GetMapping("/report/user/{id}")
    public ModelAndView getWeatherReportByUserId(@PathVariable("id") Integer id, Model model) throws Exception {
        //调用用户微服务
        User user = userFeignClient.getUserById(id);
        //调用城市微服务
        City city = cityFeignClient.getCityByName(user.getCityName());

        model.addAttribute("title", "我的天气预报");
        model.addAttribute("cityId", city.getCityId());
        model.addAttribute("cityList", getCityList());
        model.addAttribute("report", weatherReportService.getDataByCityId(city.getCityId()));

        return new ModelAndView("weather/report", "reportModel", model);
    }

    private List<City> getCityList() {
        List<City> cityList = null;
        try {
            // 调用城市数据微服务
            cityList = cityFeignClient.listCity();
        } catch (Exception e) {
            logger.error("Exception!", e);
        }
        return cityList;
    }

}
