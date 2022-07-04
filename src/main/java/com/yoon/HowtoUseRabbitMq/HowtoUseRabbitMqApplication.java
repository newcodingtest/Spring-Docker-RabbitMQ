package com.yoon.HowtoUseRabbitMq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class HowtoUseRabbitMqApplication {

	public static void main(String[] args) {
		SpringApplication.run(HowtoUseRabbitMqApplication.class, args);
	}

}
