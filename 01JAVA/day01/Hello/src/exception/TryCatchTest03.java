package exception;

public class TryCatchTest03 {
	public static void main(String[] args) {
		int[] nums = { 10 };

		try {
			System.out.println("정상코드 1");
			// System.out.println(nums[10]);
			System.out.println(10 / 0);
			System.out.println("정상코드 2");
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			System.out.println("인덱스 예외 발생 처리 코드");
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		} catch (ArithmeticException e) {
			System.out.println("0으로 나누는 등 수학적 이슈 예외 처리 구문");
		} catch (Exception e) {
			System.out.println("이외의 예외 처리");
		}
		System.out.println("프로그램 끝");

		try {
			System.out.println("정상코드 1");
			// System.out.println(nums[10]);
			System.out.println(10 / 0);
			System.out.println("정상코드 2");
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception 조상인 Exception으로 먼저 작성해버리면 아래코드는 동작 기회를 잃음
			System.out.println("인덱스 예외 발생 처리 코드");
		} catch (ArithmeticException e) {
			System.out.println("0으로 나누는 등 수학적 이슈 예외 처리 구문");
		} catch (Exception e) {
			System.out.println("이외의 예외 처리");

		}

	}
}
