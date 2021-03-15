package com.medication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MedicationDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicationDemoApplication.class, args);
	}

}
