package com.example.turf_booking_service_registry;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
@Disabled
@SpringBootTest(properties = {
		"eureka.client.enabled=false",
		"eureka.server.enabled=false",
		"spring.main.web-application-type=none"
})
class TurfBookingServiceRegistryApplicationTests {

	@Test
	void contextLoads() {
	}

}
