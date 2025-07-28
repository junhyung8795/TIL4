package generics03_method;


class Box<T>{
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
}
public class BoxTest {
	public static void main(String[] args) {
		Box<Integer> box = new Box<>();
		
		box.printClassName("String");
		box.printClassName(12.5);
		//타입 파라미터를 제네릭 메서드를 사용할 때에는 안서도 상관없지만
		//앞에 꺽쇠로 명시가능
		box.<Long>printClassName(1223);
		
	}
}
