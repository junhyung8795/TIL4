package exception;

public class TrayCatchTest04 {
	public static void main(String[] args) {
		int[] nums = {10};
		
		try {
			System.out.println("1");
			System.out.println(nums[10]);
			System.out.println("2");
			//return;//return이 붙으면 finally까지만 실행하고 return으로
			//main이 끝나버린다. 그래서 "5"는 출력이 안된다.
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			System.out.println("3");
			//return;
		} finally {
			System.out.println("4");
		}
		
		System.out.println("5");
	}
}
