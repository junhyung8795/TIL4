package ThrowsTest01;

public class ThrowsTest01 {
	public static void main(String[] args) {
		System.out.println(1);
		method1();
		System.out.println(2);
	}

	// main 메서드에서 사용하려고 static
	public static void method1()  {
		// 간접 처리, 직접처리(트라이 캐치)두 가지 선택지가 있다.

		method2();
	}

	public static void method2()  {
		// TODO Auto-generated method stub
		// Checked 계열을 발생시키자
		// 1. 직접 처리하는 방법(try-catch)
		// 2. 간접 처리하는 방법 (throws) -> 나를 호출한 곳으로 던져!
		int i = 1 / 0;
		//예외가 발생하지만 직접 처리 코드가 없어서 자동으로 던지게된다.
		//런타임 예외는 처리코드가 없어도 자신을 호출한 코드로 던진다/
		//따라서 method1에서 처리를 해야하는데,
		//따라서 main으로 또 던지게 된다.
		//그러면? main에서 예외에서도 처리 안해서 터져버린다.
		//스택 트레이스는 아래에서부터 위로 올라가면서 읽으면 된다.
		

	}
}
