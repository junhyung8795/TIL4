package com.ssafy.mvc.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;



import jakarta.servlet.http.HttpServletResponse;

@Component
public class FileUtils {
	
	
	@Value("${my-custom.upload-path}")
	private String uploadPath;
	
	// 의존성 주입을 해줘야함
	@Autowired
	private ResourceLoader resourceLoader;

	/**
	 * *
	 * 
	 * @param file 업로드할 MultipartFle 객체
	 * @return 저장된 파일 경로를 반환
	 * @throws IOException
	 */
	public String saveFile(MultipartFile file) throws IOException {
		System.out.println(file.getOriginalFilename());

		// 파일이 있으면
		if (file != null && file.getSize() > 0) {
			String fileName = file.getOriginalFilename();
			// 임시 메모리 공간에 있고, 저장하지 않으면 없어짐
			// 저장을 하겠다.
			Resource resource = resourceLoader.getResource(uploadPath);
			File target = new File(resource.getFile(), fileName);
			file.transferTo(target);

			return fileName;

		}
		return null;
	}

	/**
	 * 파일의 이름을 받아서 그 파일 객체를 반환
	 * 
	 * @param fileName
	 * @throws IOException
	 */
	public File getFile(String fileName) {
		// 이미지가 어디에 있는데? static/img
		Resource resource = resourceLoader.getResource(uploadPath);
		File file;
		try {
			file = new File(resource.getFile().getCanonicalPath(), fileName);
			return file;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	/**
	 * 받은 파일을 리스폰스로 내보내겟다.
	 * @param file
	 * @param response
	 * @throws IOException 
	 */
	public void transferTo(File file, HttpServletResponse response) throws IOException {
		try (FileInputStream fis = new FileInputStream(file); OutputStream os = response.getOutputStream();) {
			FileCopyUtils.copy(fis, os);
		}
	}
}
