package generics04_한정적사용;


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
}
public class BoxTest {
	public static void main(String[] args) {
		Box<Integer> box1 = new Box<>();
		Box<Double> box2 = new Box<>();
		
		//String은 Number를 상속받지 않아 T로 들어올 수 없다.
		//Box<String> box3 = new Box<>();
		
	}
}
