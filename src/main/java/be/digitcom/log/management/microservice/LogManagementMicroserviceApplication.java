package be.digitcom.log.management.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class LogManagementMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogManagementMicroserviceApplication.class, args);
	}

}
