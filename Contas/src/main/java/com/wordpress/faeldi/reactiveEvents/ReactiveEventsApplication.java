package com.wordpress.faeldi.reactiveEvents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import reactivefeign.spring.config.EnableReactiveFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableReactiveFeignClients
@EnableDiscoveryClient
public class ReactiveEventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveEventsApplication.class, args);
	}

}
