package generics2_generics_box;


class Box<T>{
	private T obj;
	public T getObj() {
		return obj;
	}
	
	public void setObj(T t) {
		this.obj = t;
	}
}
public class BoxTest {
	public static void main(String[] args) {
		Box box1 = new Box(); // Object -> Raw 권장하지 않음
		// Object라고 쓰고싶으면 그냥 아래처럼 써라
		Box<Object> box2 = new Box<Object>();
		
		//또한 좌항의 제네릭 타입과 우항의 제네릭 타입은 반드시 일치해야함
		//제네릭 타입은 다형성 적용안된다.
		//제네릭 타입을 지정하지 않고 생성이 가능하지만 권장x
		//이 경우엔 T가 Object로 들어감
		
		// 생성자쪽 꺽쇠안은 생략 가능-> 추정이 가능해서
		Box<String> stringBox =  new Box<>();
		//하지만 선언쪽 꺽쇠 안은 생략 불가능
		//Box<> stringBox =  new Box<String>();
		
		stringBox.setObj("안녕!");
		stringBox.getObj();
		
		//정수형을 넣고 싶어!, 꺽쇠안은 참조 자료형만 들어간다.
		//기본자료형인 int는 들어갈 수 없다.
		//참조 자료형을 넣어야해!
		Box<Integer> intBox = new Box<>();
		
		//기초 자료형 -> 참조자료형 Wrapper클래스
		//int -> Integer
		//char -> Char
		//boolean -> Boolean
		//double -> Double
		//나머지도 똑같다.
		
		int i1 = 11;//객체가 아니다.
		Integer i2 = 11;//객체이다. :AutoBoxing
		System.out.println(i2.compareTo(12));
		
		Integer i3 = Integer.valueOf(11);
		
		int i4 = i3; //객체가 아니다: AutoUnBoxing
		int i5 = i3.intValue(); //객체 x : 그냥 UnBoxing
		
		
		
	}
}
