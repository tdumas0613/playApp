package com.example.togglz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.togglz.core.Feature;
import org.togglz.core.util.NamedFeature;

@SpringBootApplication
public class TogglzApplication {
	
	@Bean
	public Feature togglz() {
		return new NamedFeature("LOG_CONFIG");
	}

	public static void main(String[] args) {
		SpringApplication.run(TogglzApplication.class, args);
	}
}
