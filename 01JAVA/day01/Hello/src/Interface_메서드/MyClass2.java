package Interface_메서드;

public class MyClass2 implements MyInterface1, MyInterface2{

	@Override
	public void method2() {
		//DEFAULT메서드가 겹치는 경우
		//구현 클래스에서 재작성 해야한다.
		//같은 이름의 디폴트 메서드가 마이인터페이스 1,2에 둘다 있기 때문에 충돌이 난다.
		//1. 구현 클래스에서 오버라이딩해서 충돌을 해결한다!
		//2.디폴트 메서드와 조상 클래스 간의 메서드 명이 동일한 경우에는 자동으로 조상 클래스의 메서드를 상속받는다.
		System.out.println("충돌 해결 메서드");
	}

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		
	}

}
