package Interface_메서드;

public interface MyInterface1 {
	void method1();
	
	default void method2() {
		System.out.println("MyInterface -> default method");
	}
	
	
}
