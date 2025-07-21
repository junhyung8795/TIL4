
public class 비교연산자 {
	public static void main(String[] args) {
		
		//비교 연산자
		System.out.println(3 < 5);// true
		System.out.println(3 > 5);// false
		
		System.out.println(3 <= 5); // true
		System.out.println(3 >= 5); // false
		System.out.println(3 > 5 || 3 == 5); //false
		System.out.println(4 <= 4); //true
		
		//동등 연산자
		System.out.println(3 == 3); // true
		System.out.println('a' == 97); //true
		System.out.println(0 == 0.0); // 이거 true이다. 형변환을 했을 때 같은 0이 되기에
		//System.out.println("1234" == 1234); //동등 연산을 하면 암묵적 형변환이 안 일어난다. 
		
		System.out.println("hello" instanceof String);// true
		System.out.println("hello" instanceof Object);// true
		//System.out.println(123 intanceof int);//기본 자료형은 객체가 아니다.
		
		//문자열에 대한 동등 연산
		System.out.println("hello" == "hello"); // true
		//원래 문자열은 객체로 내용이 같아도 다른 주소값을 가져서 값이 서로 다른다.
		//그러나 자바언어는 기본적으로 jvm을 통해 내부적으로 최적화를 함
		//문자열 풀이라는 공간에 상수 값들을 기록하게되어 해당 문자열을 변수에 참조하면 다른 변수에 할당하더라도 같은 주소값을 가진다.
		
		//문자열 동등 연산 -> 참조형 타입의 값들은 주소값을 비교한다.
		String str1 = "hello";
		String str2 = "hello";
		System.out.println("hello" == "hello"); //셋 다 true다
		System.out.println(str1 == str2);
		System.out.println(str1 == "hello");
		String str3 = new String("hello");
		System.out.println(str3 == str1); //이건 str3가 아예 새로 생성됐기 때문에 false
		
		//값이 동일한지 알고싶으면 ->equals()
		System.out.println(str1.equals(str3)); // true
	}
}
