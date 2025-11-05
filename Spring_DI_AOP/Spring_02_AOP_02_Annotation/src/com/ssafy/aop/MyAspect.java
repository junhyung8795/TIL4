package com.ssafy.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//공통 관심사항(부가기능) 저장할 클래스
@Component
@Aspect
public class MyAspect {

	// 포인트컷: 여러개의 조인 포인트(내가 작성한 아래 메서드들을 말함) 들 중 내가 들어갈 곳을 결정하는 조건
	@Pointcut("execution(* com.ssafy.aop.*.coding())")
	public void mypt() {
		// 메서드의 내용은 작성x
		// 메서드명 자체가 id
	}

	// 각 메서드명은 상관이없다. 직관적으로 보이기 위해 다음과 같이 작성.
	// 핵심 기능 수행 전
	@Before("mypt()") // value = "mypt()"랑 똑같다. "mypt()"하나만 쓰면 그냥 앞에 value = 가 있는 것.
	public void before() {
		System.out.println("컴퓨터를 부팅한다");
	}

	// 핵심 기능 정상 수행 후
	// 포인트 컷과 리턴값을 줘야한다.
	@AfterReturning(value = "mypt()", returning = "time")
	public void afterReturning(int time) {
		System.out.println("git commit을 한다. " + time + "시간만큼 처리함");
	}

	// 핵심 기능 예외 발생 후
	@AfterThrowing(value = "mypt()", throwing = "th")
	public void afterThrowing(Throwable th) {
		System.out.println("조퇴를 한다.");
		if (th instanceof OuchException) {
			((OuchException) th).handleException();
		}

	}

	// 핵심 기능 종료 후
	@After("mypt()")
	public void after() {
		System.out.println("침대에 눕는다.");
	}

	//////////////////////////////////////
	// around
	@Around("mypt()")
	public void around(ProceedingJoinPoint pjt) {

		before();
		// 핵심 관심 사항 동작할래
		try {
			Integer time = (Integer) pjt.proceed();
			afterReturning(time);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			afterThrowing(e);
		} finally {
			after();
		}

	}

}
