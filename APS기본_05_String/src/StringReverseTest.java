
public class StringReverseTest {
	/**
	 * text 문자열을 역으로 뒤집어서 반환하겠다
	 * 
	 * @param text 원본 문자열
	 * @return 뒤집은 문자열
	 */
//	private static String reverse(String text) {
//		// TODO Auto-generated method stub
//		//문자열의 길이
//		int length = text.length();
//		
//		//문자배열로 전환. String은 불변객체니 변경이 어렵다.
//		char[] charArr = text.toCharArray();
//		
//		
//		//문자열을 뒤집는다.
//		//1. 문자열의 절반만 순회하는 코드
//		for(int i = 0; i < length / 2; i++) {
//			//2. 문자를 서로 교환(swap)
//			// charArr[i] <=> charArr[N - 1 - i]
//			char temp = charArr[i];
//			charArr[i] = charArr[length -1 -i];
//			charArr[length -1 -i] = temp;
//		}
//		
//		//혹은 valueOf
//		return String.valueOf(charArr);
////		return new String(charArr);
//	}
	
	/**
	 * text 문자열을 역으로 뒤집어서 반환하겠다
	 * 이번엔 스트링 빌더로!
	 * @param text 원본 문자열
	 * @return 뒤집은 문자열
	 */
	private static String reverse(String text) {
		//스트링빌더를 쓰면 속도가 매우 빨라진다.
		StringBuilder sb = new StringBuilder(text);
		String reversed = sb.reverse().toString();
		return reversed;
		
	}
	
	public static void main(String[] args) {
		String text = "algorithm";
		
		String reversed = reverse(text);
		System.out.println(reversed);
	}
	
}
