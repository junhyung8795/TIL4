package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FileController {
	@GetMapping("/download")
	public String fileDownload(@RequestParam("fileId") String fileId, Model model) {
		model.addAttribute("fileId", fileId);
		
		//파일 아이디만 넘겼지만 fileName이라던지 기타 정보들도 같이 넘기면 좋다.
		//fileId를 이용해서 SELECT 해가지고 데이터를 모델에 실어서 넘기면 더 좋겠다.
		return "fileDownloadView";
	}
}
