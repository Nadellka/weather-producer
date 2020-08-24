package com.egen.Weather.config;

import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.amazonaws.services.sns.AmazonSNS;

@Configuration
public class MyWebMvcConfig {
	
	@Bean
	public WebMvcConfigurer MyWebMvcConfigure() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("GET","POST","PUT","PATCH","DELETE").
				allowedHeaders("*");
				
			}
		};
	}
   @Bean
   public RestTemplate createRestTemplateBean() {
	   return new RestTemplate();
   }
   
   @Bean
   public NotificationMessagingTemplate createNotificationMessagingTemplateBean(AmazonSNS amazonSns) {
	   return new NotificationMessagingTemplate(amazonSns);
   }
}
