package exception;

public class TryCatchTest01 {
	public static void main(String[] args) {
		int[] nums = {10};
		
		try {
			System.out.println("정상코드 1");
			System.out.println(nums[10]);
			System.out.println("정상코드 2");
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			System.out.println("예외 발생 처리 코드");
		} 
			
		
		System.out.println("프로그램 끝");
	}
}
