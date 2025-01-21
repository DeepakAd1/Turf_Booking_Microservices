package com.example.turf_booking_service_registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TurfBookingServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(TurfBookingServiceRegistryApplication.class, args);
	}

}
