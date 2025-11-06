package com.ssafy.mvc;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class HelloController implements Controller {
    
    @Override
    public String service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 비즈니스 로직 처리
        String message = "안녕, 서블릿";
        
        // 모델 데이터 설정
        request.setAttribute("message", message);
        
        // JSP 경로를 반환
        return "/hello";
    }
}
