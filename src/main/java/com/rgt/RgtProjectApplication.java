package com.rgt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RgtProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(RgtProjectApplication.class, args);
	}

}
