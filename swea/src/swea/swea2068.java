package swea;

import java.util.Scanner;

public class swea2068 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		
		for(int t = 0 ; t < T; t++) {
			int answer = 0;
			for(int i = 0; i < 10; i++) {
				int current = sc.nextInt();
				if(answer < current) {
					answer = current;
				}
			}
			System.out.println(answer);
			sc.nextLine();
		}
	}
}
