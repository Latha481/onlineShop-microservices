package com.onlineShop.microservices.apiGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import reactor.core.publisher.Hooks;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		Hooks.enableAutomaticContextPropagation();

		SpringApplication.run(ApiGatewayApplication.class, args);
	}


}
