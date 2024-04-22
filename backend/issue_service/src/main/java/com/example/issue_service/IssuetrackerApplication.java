package com.example.issue_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class IssuetrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(IssuetrackerApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/issues/**")
						.allowedOrigins("http://localhost:4200")
						.allowedMethods(HttpMethod.GET.toString(),
							HttpMethod.HEAD.toString(),
							HttpMethod.OPTIONS.toString(),
							HttpMethod.PUT.toString(),
							HttpMethod.POST.toString(),
							HttpMethod.DELETE.toString()
						);
			}
		};
	}
}
