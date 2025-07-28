package generics05_와일드카드;

import java.util.List;

//Num,ber를 상속받는 친구들만 T로 받을 수 있다.
class Box<T extends Number>{
	private T obj;
	public T getObj() {
		return obj;
	}
	
	public void setObj(T t) {
		this.obj = t;
	}
	
	//제네릭 메서드
	public <A> void printClassName(A item) {
		System.out.println(item.getClass().getName());
	}
	
	//인스턴스 선언뿐만 아니라 파라미터안에서도 사용할 수 있다.
	public void getList(List<? extends Number> list) {
		System.out.println(list);
	}
}

class Parent{
	
}

class Person extends Parent{
	
}

class Student extends Person{
	
}
public class BoxTest {
	public static void main(String[] args) {
		Box<?> box = new Box<Integer>();
		//Integer를 포함한 상속받고 있는 클래스들만 가능
		Box<? extends Integer> box2 = new Box<>();
		
		//Double을 포함한 상위 클래스들만 가능
		Box<? super Double> box3 = new Box<>();
		
		
	}
}
