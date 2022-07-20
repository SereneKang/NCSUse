package com.ncs.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ncs.api.repository.UserRepository;

@SpringBootApplication
@EnableEurekaClient
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class ApiSecurityGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiSecurityGatewayApplication.class, args);
	}

}
