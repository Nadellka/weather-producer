package com.egen.Weather.service;

import java.util.List;

import com.egen.Weather.model.Weather;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface WeatherService {
	
	boolean addReadings(Weather weather) throws JsonProcessingException;
    List<Weather> getWeatherReadingsSorted();
}
