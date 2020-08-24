package com.egen.Weather.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.egen.Weather.awsMessaging.WeatherAlertsSns;
import com.egen.Weather.model.Weather;
import com.egen.Weather.model.WeatherAlert;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.egen.Weather.repo.WeatherRepository;
@Service
public class DefaultWeatherService implements WeatherService {
	//List<Weather> list=new ArrayList<>();
	//private WeatherRepository weatherRepository;
	
	//private RestTemplate restTemplate;
	
	private WeatherAlertsSns weatherAlertsSns;
	
	private ObjectMapper objectMapper;
	
	@Autowired
	//WeatherRepository weatherRepository,
	//RestTemplate restTemplate,(removed dependency in constructor injection 
	public DefaultWeatherService(WeatherAlertsSns weatherAlertsSns,ObjectMapper objectMapper) {
		//this.weatherRepository=weatherRepository;
		//this.restTemplate=restTemplate;
		this.weatherAlertsSns=weatherAlertsSns;
		this.objectMapper=objectMapper;
		
	}

	@Override
	public boolean addReadings(Weather weather) throws JsonProcessingException {
		System.out.println(weather);
		//list.add(weather);
		//weatherRepository.save(weather);
		
		WeatherAlert weatherAlert=null;
		if(weather.getTemperature()>25) {
			//WeatherAlert weatherAlert=new WeatherAlert("Too Hot",weather);
			weatherAlert=new WeatherAlert("Too Hot",weather);
			//return restTemplate.postForObject("http://localhost:8081/addReadings",weatherAlert,Boolean.class);
			
			String message=objectMapper.writeValueAsString(weatherAlert);
			weatherAlertsSns.send("Temperature Alert",message);
		}
		if(weather.getWind().getSpeed()>6) {
			//WeatherAlert weatherAlert=new WeatherAlert("Too Windy",weather);
			weatherAlert=new WeatherAlert("Too Windy",weather);
			//return restTemplate.postForObject("http://localhost:8081/addReadings",weatherAlert,Boolean.class);
			String message=objectMapper.writeValueAsString(weatherAlert);
			System.out.println(message);
			weatherAlertsSns.send("Wind Alert",message);
		}
		return weatherAlert!=null;
	}

	@Override
	public List<Weather> getWeatherReadingsSorted() {
		//Using lambda expressions
		/*list.sort((weatherReading1,weatherReading2)-> {
			return weatherReading1.getTimestamp().compareTo(weatherReading2.getTimestamp());
		});*/
		
		//The comparator class has static method called comparing which
		//For example, to obtain a Comparator that compares Person objects by their last name, 
	    //Comparator<Person> byLastName = Comparator.comparing(Person::getLastName);

		/*list.sort(Comparator.comparing(Weather::getHumidity).reversed());
		return list;*/
		
		//List<Weather> weatherReadingsBySortedOrder=(List<Weather>) weatherRepository.findAll();
		//weatherReadingsBySortedOrder.sort(Comparator.comparing(Weather::getHumidity).reversed());
		//return weatherReadingsBySortedOrder;
		return null;
	}
	
	

}
