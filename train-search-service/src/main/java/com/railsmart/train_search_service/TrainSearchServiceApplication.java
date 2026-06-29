package com.railsmart.train_search_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TrainSearchServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainSearchServiceApplication.class, args);
	}

}
