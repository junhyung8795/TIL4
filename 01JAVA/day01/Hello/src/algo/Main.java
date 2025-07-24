package algo;

import java.util.Scanner;

public class Main {
	//먼저 3부분으로 나누자
	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);
		
		
		//시작하는 시간, 시 A, 분 B
		int A = sc.nextInt();
		int B = sc.nextInt();
		//필요한 조리시간 C
		int C = sc.nextInt();
		
		
		
		//로직
		//모든 시간을 최소 단위로(분) 만들어서 계산!
		//1. 최소단위로 만들게된 계산한 값을 total_minutes
		int total_minutes = (A * 60) + B + C;
		
		//2 - 1. 출력할 종료시간의 시를 만들기
		int h = (total_minutes / 60) % 24;
		
		//2 - 2. 출력할 종료시간의 분 만들기
		int m = total_minutes % 60;
		
		//출력
		System.out.printf("%d %d", h, m);
	}
}
