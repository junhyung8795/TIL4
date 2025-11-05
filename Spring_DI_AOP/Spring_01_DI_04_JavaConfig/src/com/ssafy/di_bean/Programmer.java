package com.ssafy.di_bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//컴포넌트(빈)을 등록할 때 따로 이름도 지정가능. 지정따로 안하면 클래스네임의 맨앞을 소문자로 바꾼게이름
@Component("p")
public class Programmer {
	private String name;
	private int age;
	//핵심-> 느슨한 결합을 했다.
//	@Autowired
	private Computer computer;
	
	
	
	//생성한다 -> 고용한다
	//객체생성 의존성을 제거를 하겠다
	//생성자 주입!
	public Programmer() {
		
	}
	
	@Autowired
	public Programmer(Computer computer) {
		//전에는 프로그래머를 생성하면 항상 데스크탑을 생성해줬다.
		this.computer = computer;//이전과 달리 이미 있는 데스크탑을 넣어준다. -> 객체 생성의존성을 제거함.
		
	}
	
	
	//설정자 주입을 했다!
	//맨처음에는 주입될 필요없지만 
	//상황에따라 런타임에 주입이 돼야할때 사용!
//	@Autowired
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	
	//메서드 주입해서 동시에 여러개를 넣을 수도 있다.
	
	
	public void coding() {
		System.out.println(computer.getInfo() + " 으로 개발을 합니다.");
	}
}
