package com.ssafy.di_scan;

import org.springframework.stereotype.Component;

//@Component
public class Desktop implements Computer{

	// TODO Auto-generated method stub
	private String CPU;
	private String RAM;
	private String SSD;
	private String GPU;

	public String getInfo() {
		return "데스크톱";
	}

}
