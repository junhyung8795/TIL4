package Interface_메서드;

public interface MyInterface2 {
	default void method2(){
		System.out.println("MyInterface2 -> default method 2");
	}
	
	default void method3() {
		System.out.println("MyInterface2 -> default method 3");
	}
}
