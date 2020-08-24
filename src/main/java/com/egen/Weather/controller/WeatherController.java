 package com.egen.Weather.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egen.Weather.model.Weather;
import com.egen.Weather.service.WeatherService;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
//import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiResponses;

//@Controller
//Instead of @Controller we can use
@RestController
//Now Since we used @RestController, we need not use @ResponseBody and produces
@RequestMapping("/weather")
public class WeatherController {
	
	//Using ObjectMapper from jackson which is managed by Spring
	/*@Autowired
	private ObjectMapper objectMapper;*/
	
	//Injecting the service layer here using constructor injection which is better while we test the application
	private WeatherService weatherService;
	@Autowired
	public WeatherController(WeatherService weatherService) {
		this.weatherService=weatherService;
	}
	
	
	//@RequestMapping(method=RequestMethod.GET,value="/simpleget",produces=MediaType.APPLICATION_JSON_VALUE)
    //@RequestMapping(method=RequestMethod.GET,value="/simpleget")
	//@ResponseBody
	//@GetMapping("/simple")
	@GetMapping
	public String mySimpleGetMethod() {
		return "Hi Kavya";
	}
	
	
	
	@PostMapping("/addReadings")
	@GetMapping
	@ApiOperation(value="add the weather readings from various cities", 
	notes="returns a boolean value if a reading is added")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="ok"),
			@ApiResponse(code=201,message="Added"),
			@ApiResponse(code=500,message="Internal server error")
	})
	public boolean addWeatherReading(@RequestBody Weather weather) throws JsonProcessingException {
		weatherService.addReadings(weather);
		return true;
	
	}
	
	/*@PostMapping("/addReadings")
	public boolean addWeatherReading(@RequestBody JsonNode jsonNode) throws JsonMappingException, JsonProcessingException {
		//Using object Mapper here
		Weather weather=objectMapper.readValue(jsonNode.toString(),Weather.class);
		System.out.println(jsonNode);
		System.out.println(weather);
		return true;
	}*/
	
	@GetMapping("/sortedReadings")
	@ApiOperation(value="get all readings in sorted order based on humidity", 
	notes="returns a JSON of all the readings")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="ok"),
			@ApiResponse(code=201,message="Added"),
			@ApiResponse(code=500,message="Internal server error")
	})
	public List<Weather> sortedReadingsOfWeather(){
		return weatherService.getWeatherReadingsSorted();
		
	}
}
