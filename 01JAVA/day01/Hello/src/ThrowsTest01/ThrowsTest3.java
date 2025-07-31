package ThrowsTest01;

import java.io.FileNotFoundException;
import java.io.IOException;

class Parent{
	void method1() throws IOException {
		
	}
	void method2() throws ClassNotFoundException {
		
	}
}

class Child extends Parent{

	@Override
	void method1() throws FileNotFoundException{
		// TODO Auto-generated method stub
		//조상 클래스보다 작은 범위의 예외를 던짐
	}

	@Override
	void method2() throws Exception{//빨간줄 겁나 쳐진다!
		// TODO Auto-generated method stub
		//자식클래스는 부모 클래스보다 더 큰 예외를 던질 수 없다.
	}
	
}
public class ThrowsTest3 {
	public static void main(String[] args) {
		Child c = new Child();
		c.method1();//빨간줄 쳐짐. FileNotFoundException터져서 명시적으로 또
		//main에서 처리하든 던지든 하라는 것.
	}
}
