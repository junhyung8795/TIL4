package generics01_normal_box;


class Box{
	private Object obj;
	public Object getObj() {
		return obj;
	}
	
	public void setObj(Object obj) {
		this.obj = obj;
	}
}
public class BoxTest {
	public static void main(String[] args) {
		Box box = new Box();//아무거나 넣을 수 있음!
		box.setObj("문자열임~");
		System.out.println(box.getObj());
		
		box.setObj(1000);
		System.out.println(box.getObj());
		
		
		//넣을 땐 편리하지만 꺼내 쓸 때 매번 타입 캐스팅을 해줘야하는 불편함
		if(box.getObj() instanceof String st) {
			System.out.println(st);
		} else if (box.getObj() instanceof Double d) {
			System.out.println(d);
		}
		
		
		
	}
}
