package com.egen.Weather.model;
import java.util.UUID;

/*import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;*/

//@Data
//@Table(name = "wind")
//@Entity
public class Wind {
     //@Id
    // private String id;
	 private double speed;
     private double degree;
  
	/*public Wind() {
		this.id=UUID.randomUUID().toString();
}
	
public String getId() {
	return id;
	}

	public void setId(String id) {
		this.id = id;
}*/
     public Wind() {
    	 
     }
     public Wind(double speed, double degree) {
 	
 		this.speed = speed;
 		this.degree = degree;
 	}  


	public double getSpeed() {
     return speed;
}

public void setSpeed(double speed) {
		this.speed = speed;
	}
	public double getDegree() {
		return degree;
	}
	public void setDegree(double degree) {
		this.degree = degree;
	}
	
	

	/*public Weather getWeather() {
		return weather;
	}

	public void setWeather(Weather weather) {
		this.weather = weather;
	}
	*/

	@Override
	public String toString() {
		return "Wind [speed=" + speed + ", degree=" + degree + "]";
	}
	
	

//	/*
//	 "wind": {
//    "speed": 3.1,
//    "degree": 240
//  },
//	 */
//
}
