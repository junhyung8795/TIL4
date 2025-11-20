package com.ssafy.mvc.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//로그인이 필요한 작업이다라는걸 나타내는 어노테이션 짃접 제작

@Target(ElementType.METHOD)  // 메서드에만 적용
@Retention(RetentionPolicy.RUNTIME)  // 런타임에 유지
public @interface LoginRequired {
}