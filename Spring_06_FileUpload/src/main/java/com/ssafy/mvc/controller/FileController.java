package com.ssafy.mvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.mvc.util.FileUtils;

@Controller
public class FileController {

	@Autowired
	FileUtils fileUtils;
	
	@GetMapping("/singleFileForm")
	public String singleFileForm() {
		/* System.out.println("ho?"); */
		return "singleFileForm";
	}

	@PostMapping("/singleFileUpload")
	public String singleFileUpload(@RequestParam("file") MultipartFile file, Model model)
			throws IllegalStateException, IOException {
		
		String filePath = fileUtils.saveFile(file);
		model.addAttribute("filePath", filePath);
		return "result";
	}

	@GetMapping("/download")
	public String fileDownlad(@RequestParam("fileName") String fileName, Model model) {
		model.addAttribute("fileName", fileName);
		return "fileDownloadView";
	}

	@GetMapping("/multiFileForm")
	public String multiFileForm() {
		/* System.out.println("ho?"); */
		return "multiFileForm";
	}

	@PostMapping("/multiFileUpload")
	public String multiFileUpload(@RequestParam("files") MultipartFile[] files, Model model)
			throws IllegalStateException, IOException {
		List<String> filePaths = new ArrayList<>();
		
		for (MultipartFile file : files) {
			String filePath = fileUtils.saveFile(file);
			filePaths.add(filePath);
		}
		
		model.addAttribute("filePaths", filePaths);
		return "result";
	}
}
