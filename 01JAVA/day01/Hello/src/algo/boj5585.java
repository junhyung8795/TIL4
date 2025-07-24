import java.util.Scanner;

public class boj5585 {
	public static void main(String[] args) {
		// 입력 
		Scanner sc = new Scanner(System.in);
		
		// 지불해야할 금액 pay_amount
		int pay_amount = sc.nextInt();
		
		
		// 계산된 거스름돈의 개수 (count)
		int count = 0;
		// 로직
		// 1. 거스름돈 액수를 계산 (change)
		int change = 1000 - pay_amount;
		
		// 2. 500원 단위를 거슬러 준다...!
		// 2-1. 거스름돈의 갯수를 갱신(update)
		// 2-2. 거스름돈의 액수를 갱신(update)
		count = change / 500;
		change = change % 500;
		
		// 3. 100원 단위를 거슬러 준다...!
		count = count + (change / 100);
		change = change % 100;
		
		// 4. 50원...
		count = count + (change / 50);
		change = change % 50;
		
		// 5. 10원...
		count = count + (change / 10);
		change = change % 10;
		
		// 5. 5원...
		count = count + (change / 5);
		change = change % 5;
		
		// 6. 1원...
		count = count + change;
//		change = 0;
		
		
		// 출력
		System.out.println(count);
	}
}
