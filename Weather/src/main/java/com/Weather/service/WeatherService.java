package com.Weather.service;

public interface WeatherService {

    public Object getForecastSummaryByLocationName(String city);

    public Object getHourlyForecastSummaryByLocationName(String name);
}
