package com.egen.Weather.model;

import java.sql.Timestamp;
import java.util.UUID;

/*import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import com.egen.Weather.model.Wind;*/
//@Data
//@NoArgsConstructor

//@Entity()
public class Weather {
	//@Id
	//private String id;
	private String city;
	private String description;
	private double humidity;
	private double pressure;
	private double temperature;
	
	/* @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
	*/
	private Wind wind;
	private Timestamp timestamp;

	
	/*public Weather() {
		this.id=UUID.randomUUID().toString();
	}*/
    
	//All Args Constructor, to create object while testing in utils folder
	
	
	/*public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}*/
	
	public Weather(String city, String description, double humidity, double pressure, double temperature, Wind wind,
			Timestamp timestamp) {

		this.city = city;
		this.description = description;
		this.humidity = humidity;
		this.pressure = pressure;
		this.temperature = temperature;
		this.wind = wind;
		this.timestamp = timestamp;
	}




	public String getCity() {
		return city;
	}


	
	public void setCity(String city) {
		this.city = city;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getHumidity() {
		return humidity;
	}


	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}


	public double getPressure() {
		return pressure;
	}


	public void setPressure(double pressure) {
		this.pressure = pressure;
	}


	public double getTemperature() {
		return temperature;
	}


	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}


	public Wind getWind() {
		return wind;
	}


	public void setWind(Wind wind) {
		this.wind = wind;
	}


	public Timestamp getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
 

	@Override
	public String toString() {
		return "Weather [city=" + city + ", description=" + description + ", humidity=" + humidity
				+ ", pressure=" + pressure + ", temperature=" + temperature + ", wind=" + wind + ", timestamp="
				+ timestamp + "]";
	}


	
	
	
	
	/*
	 {
  "city": "Chicago",
  "description": "scattered clouds",
  "humidity": 33,
  "pressure": 1020,
  "temperature": 25,
  "wind": {
    "speed": 3.1,
    "degree": 240
  },
  "timestamp": "2017-02-14T05:48:41.861Z"
}
	 */
	
	

}
