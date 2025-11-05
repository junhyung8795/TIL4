package com.ssafy.di;

public class ComputerFactory {
	public static Computer getComputer(String type) {
		if(type.equals("D")){
			return new Desktop();
		} else if(type.equals("L")) {
			return new Laptop();
		}
		return null;
	}
}
