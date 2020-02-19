package com.ceiba.adn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.ceiba.adn")
@EnableJpaRepositories(basePackages = "com.ceiba.adn")
@ComponentScan(value = {"com.ceiba.adn"})
@EnableAutoConfiguration
public class AdnApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdnApplication.class, args);
	}

}
