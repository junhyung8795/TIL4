package DI_의존성개념_04_의존성주입;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
//		//프로그래머가 데스크톱에 대한 의존성을 가지고 있다.
//		Computer desktop = new Desktop();
//		Computer laptop = new Laptop();
//		//프로그래머는 laptop도 받을 수 있다.
//	
//		Programmer p = new Programmer(desktop); //컴퓨터를 하나사서 알아서 프로그래머에게 쥐어줌
//		p.coding();
//		p.setComputer(laptop);
//		p.coding();
//		
		
		
		Programmer p = new Programmer();
		Scanner sc = new Scanner(System.in);
		while(true) {
			p.setComputer(ComputerFactory.getComputer(sc.next()));
			p.coding();
		}
	
	}
}
	