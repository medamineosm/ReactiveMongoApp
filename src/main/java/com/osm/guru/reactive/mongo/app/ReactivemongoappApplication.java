package com.osm.guru.reactive.mongo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@EnableReactiveMongoRepositories
@EnableMongoAuditing
@SpringBootApplication
public class ReactivemongoappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactivemongoappApplication.class, args);
	}
}
