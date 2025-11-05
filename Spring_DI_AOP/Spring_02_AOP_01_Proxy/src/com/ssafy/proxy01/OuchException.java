package com.ssafy.proxy01;

public class OuchException extends Exception{
	public void handleException() {
		System.out.println("병원에 간다.");
	}
}
