import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class String01_생성 {
	public static void main(String[] args) {
		// 1. 리터럴 사용 -> String Pool
		String str1 = "Hello";
		String str2 = "Hello";

		System.out.println(str1 == str2);// 객체에서 ==비교연산자는 주소비교지만 true가 출력
		System.out.println(str1.equals(str2));

		// 2. 힙에 직접 생성
		String str3 = new String("Hello");
		System.out.println(str1 == str3); // false
		System.out.println(str1.equals(str3));// true
		
		//3. 바이트 배열 이용
		byte[] bytes = new byte[] {65,66,67};
		String str4 = new String(bytes, StandardCharsets.UTF_8);
		System.out.println(str4);
		
		////////////////////////////
		//문자열은 불변성! -> 중간 문자를 바꾸고 싶다면 문자의 배열로 바꾼 뒤에
		//특정 문자를 바꾸고 다시 문자열로 만들어야 한다.
		char[] cArr1 = new char[str1.length()];
		
		for(int i = 0; i < cArr1.length; i++) {
			cArr1[i] = str1.charAt(i);
		}
		System.out.println(Arrays.toString(cArr1));
		
		char[] cArr2 = str1.toCharArray();
		System.out.println(Arrays.toString(cArr2));
		
		//자바에서 문자 한개를 입력받는 방법?-> 없다. 
		//문자열로 일단 받고 변환해야한다.
		Scanner sc = new Scanner(System.in);
		//sc.next()까지는 문자열이므로 객체이다.객체에는 도트(.) 사용가능
		//String tmp = sc.next();
		//sc.next().charAt(0);//해당 방식으로 문자열을 입력 받아 문자로 변환
		
		//패턴 매칭. 문자열에 내가 찾고자하는 문자열이 있느냐를 검사하는 것.
		System.out.println(str1.contains("lo"));
		
	}
}
