//package com.ssafy.mvc.view;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.OutputStream;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.ResourceLoader;
//import org.springframework.stereotype.Component;
//import org.springframework.util.FileCopyUtils;
//import org.springframework.web.servlet.view.AbstractView;
//
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssafy.mvc.util.FileUtils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FileDownloadView extends AbstractView {

	@Autowired
	private FileUtils fileUtils;
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// Map에 파일네임이 들어있음 컨트롤러에서 model에 이름을 넣어서 보냈기 때문
		String fileId = (String) model.get("fileId");

/////////////////
		fileId = new String(fileId.getBytes("UTF-8"), "ISO-8859-1");
		response.setContentType("img/png");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileId + "\";");
		response.setHeader("Content-Tranfer-Encoding", "binary");
//////////////////

		File file = fileUtils.getFile(fileName);
		// 파일을 다운로드 하자.
		fileUtils.transferTo(file, response);
	}

}
