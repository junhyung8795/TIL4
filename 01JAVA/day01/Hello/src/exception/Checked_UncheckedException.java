package exception;

public class Checked_UncheckedException {
	public static void main(String[] args) {
		
		//1. UnCheckedException
		//런타임 계열 -> 프로그래머의 실수 / 컴파일 시 대처 코드가 없어도 ok
		int[] nums = {10};
		System.out.println(nums[10]);
		
		//2. Checked
		//Exceptiom 계열 -> 컴파일시 대처코드가 없으면 안된다.
		//Class.forName(null);
		Thread.sleep(10);
	}
}
