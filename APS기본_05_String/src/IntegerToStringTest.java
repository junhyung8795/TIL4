
public class IntegerToStringTest {
	public static void main(String[] args) {
		int num = 1234;
		String text = itoa(num);
		System.out.println(text);
	}

	/**
	 * 정수형 변수를 문자열로 반환해라
	 * @param num
	 * @return
	 */
	private static String itoa(int num) {
		
//		return String.valueOf(num);
//		return num + "";
		
		//num값을 10으로 나누면서 한자리씩 문자열로 전환
//		StringBuilder sb = new StringBuilder();
		String result = "";
		while(num > 0) {
			//한자리씩 자리수를 빼낸다.
			int remain = num % 10; //나머지 4
			num = num / 10;		   //몫 123
//			sb.append(remain); //'4' '3' '2' '1'
//			result = result + num; // result는 "4321"이된다.
			result = num + result;//라고하면 rsult는 "1234"가된다.
		}
		//거구로 저장됐으니 뒤집는다./
		return sb.reverse().toString();
		
	}
}
