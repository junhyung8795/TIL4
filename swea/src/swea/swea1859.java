package swea;
import java.io.*;
import java.util.*;


public class swea1859 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		
		for(int t = 0; t < T; t++) {
			int N = sc.nextInt();
			sc.nextLine();
			long[] numArr = new long[N];
			for(int
					i = 0 ; i < N; i++) {
				numArr[i] = sc.nextLong();
			}
			
			long answer = 0L;
			long nowExpectedMax = numArr[N - 1];
			for(int current = N - 1; current >= 0; current--) {
				if(nowExpectedMax < numArr[current]) {
					nowExpectedMax = numArr[current];
				} else {
					answer += nowExpectedMax - numArr[current];
				}
			}
			System.out.printf("#%d %d", t + 1, answer);
			
			
			sc.nextLine();
			
		}
		
	}
}
