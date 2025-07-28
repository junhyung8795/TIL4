package Interface;

//완벽히 추상화된 설계도
public interface Myinterface {
	//추상 메서드를 정의했다(구현부는 ;로 대체
	public abstract void method1();
	void method2();// public abstract
	
	//멤버필드인가? -? 인터페이스 자체는 객체를 생성할 수 없다.
	//무언가 생략이 돼있다
	//public static final이 생략돼 있다.
	//static은 미리 메서드 영역에 올라가사 클래스 영역에 존재
	//final은 한번 할당되면 값이 변하지 않는다.
	int NUMBER1 = 100;
}
