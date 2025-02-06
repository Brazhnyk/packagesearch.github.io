package com.peakwork.trainee.brazhnyk.hotelInfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class HotelInfoApplication {
	public static void main(String[] args) {
		SpringApplication.run(HotelInfoApplication.class, args);
	}

}
