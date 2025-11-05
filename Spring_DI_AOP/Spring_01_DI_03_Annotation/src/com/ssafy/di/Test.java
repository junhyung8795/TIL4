package com.ssafy.di;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		//설정파일에 대한 경로 작성
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
				
		Desktop desktop = (Desktop)context.getBean("desktop");//xml에 적어놓은 아이디로 가져온다.
		
//		System.out.println(desktop.getInfo());
		
		Programmer p = context.getBean("p", Programmer.class);
		p.coding();
	}
}
	