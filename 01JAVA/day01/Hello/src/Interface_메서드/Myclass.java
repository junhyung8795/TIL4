package Interface_메서드;

public class Myclass implements MyInterface1 {

	@Override
	public void method1() {
		System.out.println("디폴트가 아닌 메서드");
	}
	//METHOD2는 구현이 강제성이 없다.

	@Override
	public void method2() {
		// TODO Auto-generated method stub
//		MyInterface1.super.method2();
		System.out.println("클래스에서 제정의한게 우선 순위가 더 높다.");
	}
	
	
	public void method3() {
		System.out.println("인터페이스 구현에는 없지만 조상 클래스 자체가 가지고 있는 method3!");
	}

}
