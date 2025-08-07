
public class StringToIntegerTest {
	private static int atoi(String str) {

		// 숫자로 해당 문자를 하나씩 뜯어서 숫자화
		// "1234" -? '1' '2' '3' '4'로 뜯고 숫자로 만드는 것.
		int result = 0;
		// 문자열에서 문자들을 순회하는 코드가 필요하다.
		for (char ch : str.toCharArray()) {
			// 아스키코드값을 숫자로 바꾸기
			// ch('7') - ch('0') -> 숫자 7이 된다.
			result = (result * 10) + (ch - '0');
		}

		return 0;
	}

	public static int atoi(char[] chs) {
		// 숫자로 해당 문자를 하나씩 뜯어서 숫자화
		// "1234" -? '1' '2' '3' '4'로 뜯고 숫자로 만드는 것.
		int result = 0;
		// 문자열에서 문자들을 순회하는 코드가 필요하다.
		for (char ch : chs) {
			// 아스키코드값을 숫자로 바꾸기
			// ch('7') - ch('0') -> 숫자 7이 된다.
			result = (result * 10) + (ch - '0');
		}

		return 0;
	}

	public static void main(String[] args) {
		String str = "1234";
		int num = atoi(str);
		System.out.println(num + 1);
		System.out.println();
	}

}
