package com.ssafy.proxy02;

import java.util.Random;

public class PersonProxy implements Person {
	
	private Person person; //때로는 프로그래머, 때로는 싸피생.
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	
	
	
	@Override
	public void coding() {
		System.out.println("컴퓨터 부팅하고"); // 이전에 수행할 기능

		try {
			
			//핵심기능만 커스텀!
			person.coding();//프로그래머면 프로그래머의 핵심기능. 싸피생이면 싸피생이 핵심기능 수행.
			// if문을 이용해 랜덤하게 예외를 발생시킨다.
			if (new Random().nextBoolean()) {
				throw new OuchException();
			}

			System.out.println("git commit을 한다."); // 정상적으로 종료가 됐다.
		} catch (OuchException e) {
			// TODO: handle exception
			e.handleException();// 비정상 종료됐을 때.
		} finally {
			System.out.println("집에가서 침대에 눕는다.");
		}

	}
}
