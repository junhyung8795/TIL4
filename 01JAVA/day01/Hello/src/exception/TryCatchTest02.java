package exception;

public class TryCatchTest02 {
	public static void main(String[] args) {
		int[] nums = {10};
		
		try {
			System.out.println("정상코드 1");
			//System.out.println(nums[10]);
			System.out.println(10 / 0);
			System.out.println("정상코드 2");
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			System.out.println("인덱스 예외 발생 처리 코드");
		} catch(ArithmeticException e) {
			System.out.println("0으로 나누는 등 수학적 이슈 예외 처리 구문");
		}
		System.out.println("프로그램 끝");
		
		
		try {
			System.out.println("정상코드 1");
			//System.out.println(nums[10]);
			System.out.println(10 / 0);
			System.out.println("정상코드 2");
		} catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
			// TODO: handle exception
			System.out.println("인덱스 예외 발생 처리 코드");
			System.out.println("0으로 나누는 등 수학적 이슈 예외 처리 구문");
			//if (e instanceof ArrayIndexOutOfBoundsException){} -> 이렇게 구별가능하다
		} 
		System.out.println("프로그램 끝");
	}
}
