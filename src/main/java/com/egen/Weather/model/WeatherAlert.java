package com.egen.Weather.model;

public class WeatherAlert {
private String alert;
private Weather weather;
public WeatherAlert(String alert, Weather weather) {
	
	this.alert = alert;
	this.weather = weather;
}
public String getAlert() {
	return alert;
}
public void setAlert(String alert) {
	this.alert = alert;
}
public Weather getWeather() {
	return weather;
}
public void setWeather(Weather weather) {
	this.weather = weather;
}
@Override
public String toString() {
	return "WeatherAlert [alert=" + alert + ", weather=" + weather + "]";
}


}
