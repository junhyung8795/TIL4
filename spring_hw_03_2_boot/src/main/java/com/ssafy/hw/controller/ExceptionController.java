package com.ssafy.hw.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
 * ========================================
 * 선택 학습 내용 - 지금은 완성하지 않으셔도 됩니다!
 * ========================================
 *
 * 이 파일은 전역 예외 처리를 위한 것으로,
 * Spring AOP와 @ControllerAdvice 개념을 학습한 후 다루게 됩니다.
 *
 * 현재는 참고만 하시고, 필수 과제인 UserController 완성에 집중하세요.
 *
 * @ControllerAdvice란?
 * - 모든 컨트롤러에서 발생하는 예외를 한 곳에서 처리할 수 있게 하는 어노테이션입니다.
 * - Spring AOP(관점 지향 프로그래밍) 개념을 기반으로 동작합니다.
 * - 이 개념은 Spring 심화 과정으로 차후 학습하실 수 있습니다.
 *
 * BindException이란?
 * - 사용자가 입력한 데이터를 객체에 바인딩할 때 발생하는 예외입니다.
 * - 예: age 필드에 숫자가 아닌 문자를 입력한 경우
 *
 * ========================================
 */

// 컨트롤러 전역에서 발생하는 예외를 처리하는 부가기능을 가진 클래스(어드바이스)
 @ControllerAdvice
public class ExceptionController {
	
	private static Logger logger = LoggerFactory.getLogger(ExceptionController.class);
	
	// 예외를 어떻게 처리할지 정의
	 @ExceptionHandler(Exception.class)
	 public String handleException(Model model, Exception e) {
	 	logger.error("예외 발생" , e.getCause());
		
	 	// 파라미터 바인딩 예외 발생시
	 	if(e instanceof BindException) {			
	 		model.addAttribute("message", "파라미터가 잘 등록되지 않았습니다." );
	 	}
		
	 	return "/error/errorpage";
	 }
	
}
