package com.ssafy.hw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringHw032BootApplication {

	public static void main(String[] args) {
		ApplicationContext appcxt = SpringApplication.run(SpringHw032BootApplication.class, args);

		// 등록된 빈들을 모두 출력!
//		appcxt.getBeanDefinitionNames();
		for (String beanName : appcxt.getBeanDefinitionNames()) {
			System.out.println(beanName);
		}
	}

}
