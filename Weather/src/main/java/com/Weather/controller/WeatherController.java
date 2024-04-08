package com.Weather.controller;

import com.Weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class WeatherController {


    @Autowired
    WeatherService weatherService;




    @GetMapping("/rapidApiGetForecastSummaryByLocationName/{city}")
    public Object getForecastSummaryByLocationName(@PathVariable("city") String city ){



        return weatherService.getForecastSummaryByLocationName(city);
    }

    @GetMapping("/rapidApiGetHourlyForecastByLocationName/{city}")
    public Object getHourlyForecastSummaryByLocationName(@PathVariable("city") String city ){



        return weatherService.getForecastSummaryByLocationName(city);
    }


}
