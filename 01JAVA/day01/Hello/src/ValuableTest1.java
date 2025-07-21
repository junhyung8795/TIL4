
public class ValuableTest1 {
	//1.변수 a와 b를 정수형으로 선언하라
	public static void main(String[] args) {
//		int a;
//		int b;
//		
//		// 2. a랑 b에 할당
//		a = 3;
//		b = 4;
		
		// 3. 초기화와 할당을 동시에
		int a = 3;
		int b = 4;
		
		// 값 교환
//		int prev = a;
//		a = b;
//		b = prev;
		
		// 추가 상자 없이, prev없이 하는 법 -> XOR연산
		a = a ^ b; //XOR의 특징. a ^ key ^ key를 하면 a가 된다.
		b = a ^ b; // -> ,a ^ b ^ b는 a값이 된다.
		a = a ^ b; // -> a ^ b ^ a 는 b값이 된다. 
		
		System.out.println(a + " " + b);
		
		// 오버플로우를 강제로 일어나게해보자
		int c = 20_0000_0000;
		int d = 2_0000_0000;
		System.out.println(c + d);
		//System.out - > 표준 출력 스트림(데이터가 전달되는 관계, 단방향으로 흐르는 흐름)
	}
}
