package com.ssafy.di_bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.ssafy.di_scan"})
public class ApplicationConfig {
	
	@Bean
	public Desktop desktop() {
		return new Desktop();
	}
}
