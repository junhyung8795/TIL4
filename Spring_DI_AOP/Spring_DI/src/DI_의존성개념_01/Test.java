package DI_의존성개념_01;

public class Test {
	public static void main(String[] args) {
		//프로그래머가 데스크톱에 대한 의존성을 가지고 있다.
		Programmer p = new Programmer(); //컴퓨터를 하나사서 알아서 프로그래머에게 쥐어줌
		
		p.coding();
	}
}
