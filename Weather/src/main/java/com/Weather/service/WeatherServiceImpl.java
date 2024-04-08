package com.Weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class WeatherServiceImpl implements  WeatherService{


    @Autowired
    private RestTemplate restTemplate;


    @Override
    public Object getForecastSummaryByLocationName(String city) {

        String  url = "https://forecast9.p.rapidapi.com/rapidapi/forecast/{cityValue}/summary/";

        url =   url.replace("{cityValue}" , city);

         String xRapidApiKey = "655b9f9685msh9a8b75b1cd88e11p1c2caejsn98513ea47759";

         String xRapidHost = "forecast9.p.rapidapi.com";

        HttpHeaders headers = new HttpHeaders();

        headers.set("X-RapidAPI-Key", xRapidApiKey);
        headers.set("X-RapidAPI-Host", xRapidHost);

        ResponseEntity<Object> response = restTemplate.exchange(url , HttpMethod.GET , new HttpEntity<>(headers) , Object.class);

        return response;

    }

    @Override
    public Object getHourlyForecastSummaryByLocationName(String name) {

        String  url = "api.openweathermap.org/data/2.5/forecast?q={city name}&appid=c463b47d57b84be0c36e4f11f5f7e62c";

        url =   url.replace("{city name}" , name);

        HttpHeaders headers = new HttpHeaders();

        ResponseEntity<Object> response = restTemplate.exchange(url , HttpMethod.GET , new HttpEntity<>(headers) ,  Object.class);

        return response;
    }
}
