package com.ssafy.proxy01;

import java.util.Random;

public class Programmer {
	//필드 생략
	
	//주된 일상
	public void coding() {
		System.out.println("컴퓨터 부팅하고"); // 이전에 수행할 기능
		
		try {
			System.out.println("열심히 코드를 작성함."); // 핵심 기능 이때 예외가 발생할 수 있다.
			//if문을 이용해 랜덤하게 예외를 발생시킨다.
			if(new Random().nextBoolean()) {
				throw new OuchException();
			}
			
			System.out.println("git commit을 한다."); // 정상적으로 종료가 됐다.
		} catch (OuchException e) {
			// TODO: handle exception
			e.handleException();//비정상 종료됐을 때.
		} finally {
			System.out.println("집에가서 침대에 눕는다.");
		}
		
		
		
		
		
	}
}
