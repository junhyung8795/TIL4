package com.ssafy.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;



@SpringBootApplication
public class Spring05IntercepterApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Spring05IntercepterApplication.class, args);
		
//		for(String bean: context.getBeanDefinitionNames()) {
//			System.out.println(bean);
//		}
	}

}
