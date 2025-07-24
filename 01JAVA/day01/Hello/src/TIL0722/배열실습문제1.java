package TIL0722;

public class 배열실습문제1 {
	public static void main(String[] args) {
		int[] nums = { 0, 0, 0, 0, 0, 1 };
		int min1 = Integer.MAX_VALUE;
		int max1 = -Integer.MAX_VALUE;
		int sum1 = 0;
		int avg1 = 0;
		for (int i = 0; i < nums.length; i++) {
			if (min1 > nums[i]) {
				min1 = nums[i];
			}

			if (max1 < nums[i]) {
				max1 = nums[i];
			}

			sum1 += nums[i];
		}

		avg1 = sum1 / nums.length;

		System.out.printf("최솟값: %d\n", min1);
		System.out.printf("최댓값: %d\n", max1);
		System.out.printf("합: %d\n", sum1);
		System.out.printf("평균: %d\n", avg1);
	}
}
