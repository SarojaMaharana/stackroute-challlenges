package com.stackroute.newz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class NewsSourceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsSourceServiceApplication.class, args);
	}

}
