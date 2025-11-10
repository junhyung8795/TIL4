package com.ssafy.hw.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssafy.hw.model.dto.User;

// 이 클래스가 컨트롤러 임을 어노테이션으로 설정, 컴포넌트 스캔을 통해 빈으로 등록
@Controller
public class UserController {
	// 유저 정보를 담을 리스트 (임시)
	List<User> list = new ArrayList<User>();

	public UserController() {
		// 아직 DB에 연결하지 않았으므로 임의로 사용자 정보 4개를 생성해서 list에 담아 전달한다.
		list.add(new User("ssafy1", "1234", "김싸피", "ssafy1@ssafy.com", 26));
		list.add(new User("ssafy2", "1234", "박싸피", "ssafy2@ssafy.com", 26));
		list.add(new User("ssafy3", "1234", "이싸피", "ssafy3@ssafy.com", 26));
		list.add(new User("ssafy4", "1234", "강싸피", "ssafy4@ssafy.com", 26));
	}

	/**
	 * '/' 또는 '/index' 요청이 get 방식으로 들어왔을 때 index로 연결한다.
	 * 
	 * @return
	 */
	@GetMapping({ "/", "/index" })
	public String showIndex() {
		return "index";
	}

	// ========================================
	// 필수 완성 사항: 아래 4개 메서드의 빈칸을 채워 완성하세요
	// ========================================

	// /**
	// * '/regist' 요청이 get 방식으로 들어왔을 때 regist로 연결한다.
	// *
	// * 힌트: @GetMapping 어노테이션을 사용하세요
	// * @return 뷰 이름 (문자열)
	// */
//	 @RequestMapping(value= "/regist", method = RequestMethod.GET)
	@GetMapping("/regist")
	public String showRegistForm() {
		return "regist";
	}

	// /**
	// * '/regist' 요청이 post 방식으로 들어왔을 때 전달된 User 객체를 regist_result로 연결한다.
	// *
	// * 힌트: @PostMapping 어노테이션을 사용하세요
	// * 힌트: 메서드 파라미터로 User 객체와 Model 객체를 받아야 합니다
	// * @param user 사용자가 입력한 정보가 자동으로 바인딩되는 User 객체
	// * @param model 뷰에 데이터를 전달하기 위한 Model 객체
	// * @return 뷰 이름 (문자열)
	// */
	@PostMapping("/regist")
	public String doRegist(User user, Model model) {
		// 유저 객체 정보를 리스트에 추가
		list.add(user);
		// Model 객체에 user 데이터를 담아서 뷰로 전달
		model.addAttribute("user", user);
		return "regist_result";
	}

	// /**
	// * '/list' 요청이 get 방식으로 들어왔을 때 User List를 Model에 담아서 list로 연결한다.
	// *
	// * 힌트: @GetMapping 어노테이션을 사용하세요
	// * 힌트: 메서드 파라미터로 Model 객체를 받아야 합니다
	// * 힌트: void 반환 시 요청 URL과 같은 이름의 뷰를 자동으로 찾습니다
	// * @param model 뷰에 데이터를 전달하기 위한 Model 객체
	// */
	@GetMapping("/list")
	public void showList(Model model) {
		// list 변수에 담긴 사용자 목록을 Model에 담아 뷰로 전달
		model.addAttribute("users", list);
	}

	// /**
	// * '/error/404' 요청이 get 방식으로 들어왔을 때 보여줄 페이지
	// *
	// * 힌트: @GetMapping 어노테이션을 사용하세요
	// * 힌트: void 반환이므로 자동으로 "/error/404" 경로의 뷰를 찾습니다
	// *
	// * 참고: web.xml의 error-page 설정으로 인해 404 에러 발생 시 자동으로 이 메서드가 호출됩니다
	// */
	@GetMapping("/error/404")
	public void showError404() {
		// 404 Not Found 처리
		// 별도의 처리 없이 해당 뷰만 보여주면 됩니다
	}
}
