package com.rgt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class AuditLoggingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuditLoggingApplication.class, args);
	}

}