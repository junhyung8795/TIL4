package DI_의존성개념_02_객체생성의존성제거;

public class Test {
	public static void main(String[] args) {
		//프로그래머가 데스크톱에 대한 의존성을 가지고 있다.
		Desktop desktop = new Desktop();
		
		//객체 생성의존성을 제거하여 이미 만들어진 데스크탑을 넣어줫다.
		Programmer p = new Programmer(desktop); //컴퓨터를 하나사서 알아서 프로그래머에게 쥐어줌
		
		p.coding();
	}
}
	