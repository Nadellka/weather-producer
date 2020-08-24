package com.egen.Weather.awsMessaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.stereotype.Component;

import com.amazonaws.services.sns.AmazonSNS;
@Component
//Using this we are going to send weather alerts to Sns using NotificationMessagingTemplate
public class WeatherAlertsSns {
	private final NotificationMessagingTemplate notificationMessagingTemplate;
	@Value("${weather.alert.topic}")
	private String topic;
	
	/*@Autowired
	public WeatherAlertsSns(AmazonSNS amazonSns) {
		this.notificationMessagingTemplate=new NotificationMessagingTemplate(amazonSns);
		
	}*/
	
	@Autowired
	public WeatherAlertsSns(NotificationMessagingTemplate notificationMessagingTemplate) {
		this.notificationMessagingTemplate=notificationMessagingTemplate;
		}
	
	public void send(String subject,String message) {
		this.notificationMessagingTemplate.sendNotification(topic, message, subject);
	}

}
