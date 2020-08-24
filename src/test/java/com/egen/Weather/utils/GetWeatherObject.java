package com.egen.Weather.utils;

import com.egen.Weather.model.Weather;
import com.egen.Weather.model.Wind;

public class GetWeatherObject {
	public static Weather getWeatherObject() {
		return new Weather("Chicago","scattered clouds",33,1020,23,new Wind(),null);
	}
	
	public static Weather getWeatherObjectTemperatureAlertGenerator() {
		return new Weather("Austin","Hot",33,1020,29,new Wind(),null);
	}
	
	public static Weather getWeatherObjectWindAlertGenerator() {
		return new Weather("Austin","Hot",33,1020,29,new Wind(7,250),null);
	}
}
