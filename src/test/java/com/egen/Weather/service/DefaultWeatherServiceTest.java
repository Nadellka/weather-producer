package com.egen.Weather.service;

import static org.junit.Assert.fail;

import org.assertj.core.internal.bytebuddy.matcher.ElementMatchers;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.egen.Weather.awsMessaging.WeatherAlertsSns;
import com.egen.Weather.model.WeatherAlert;
import com.egen.Weather.utils.GetWeatherObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



//This class will be run using this particular class called MockitoJunitRunner.class
@RunWith(MockitoJUnitRunner.class)
public class DefaultWeatherServiceTest {
	
	private WeatherService defaultWeatherService;
	
	@Mock
	private WeatherAlertsSns weatherAlertsSns;
	
	@Mock
	private ObjectMapper objectMapper;
	
	
	@Before
	public void setUp() {
		defaultWeatherService=new DefaultWeatherService(weatherAlertsSns,objectMapper);
	}
//TestCase1
	@Test
	public void testAddReadings1() throws JsonProcessingException {
		boolean b=defaultWeatherService.addReadings(GetWeatherObject.getWeatherObject());
		//Assert.assertEquals(b,false);
		Assert.assertFalse(b);
		
	}
	
	//TestCase2
	@Test
	public void testAddReadings2() throws JsonProcessingException {
		boolean b=defaultWeatherService.addReadings(GetWeatherObject.getWeatherObjectTemperatureAlertGenerator());
		//Assert.assertEquals(b,false);
		Assert.assertEquals(b,true);
		
	}
	
	//TestCase3
		@Test
		public void testAddReadings3() throws JsonProcessingException {
			Mockito.when(objectMapper.writeValueAsString(ArgumentMatchers.any(WeatherAlert.class))).thenReturn("HelloWorld");
			boolean b=defaultWeatherService.addReadings(GetWeatherObject.getWeatherObjectWindAlertGenerator());
			//Assert.assertEquals(b,false);
			
			Assert.assertTrue(b);
			
		}


}
