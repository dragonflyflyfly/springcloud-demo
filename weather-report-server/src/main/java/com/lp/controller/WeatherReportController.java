package com.lp.controller;

import com.lp.feign.CityFeignClient;
import com.lp.service.WeatherReportService;
import com.lp.vo.City;
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

    @GetMapping("/report/cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception {
        List<City> cityList = null;
        try {
            // 调用城市数据微服务
            cityList = cityFeignClient.listCity();
        } catch (Exception e) {
            logger.error("Exception!", e);
        }

        model.addAttribute("title", "我的天气预报");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", cityList);
        model.addAttribute("report", weatherReportService.getDataByCityId(cityId));

        return new ModelAndView("weather/report", "reportModel", model);
    }

}
