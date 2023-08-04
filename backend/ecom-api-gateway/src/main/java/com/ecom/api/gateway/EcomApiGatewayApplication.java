package com.ecom.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EcomApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomApiGatewayApplication.class, args);
	}

}
