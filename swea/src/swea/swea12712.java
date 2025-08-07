package swea;

import java.io.*;
import java.util.*;

public class swea12712 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		System.setIn(new FileInputStream("in1.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();

		for (int t = 0; t < T; t++) {

			int N = sc.nextInt();
			int M = sc.nextInt();
			sc.nextLine();
			int[][] table = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					table[i][j] = sc.nextInt();
				}
				sc.nextLine();
			}

			int answer = 0;
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					answer = Math.max(answer, xSearch(row, col, table, N, M));
					answer = Math.max(answer, tSearch(row, col, table, N, M));
					
				}
			}
			System.out.println(answer);
		}

	}

	private static int tSearch(int row, int col, int[][] table,int N, int M) {
		// TODO Auto-generated method stub
		int cnt = table[row][col];
		//위
		for(int start = row - 1; start >= 0 &&  row - start <= M - 1; start--) {
			cnt += table[start][col];
		}
		//오른쪽
		for(int start = col + 1; start < N  && start - col <= M - 1; start++) {
			cnt += table[row][start];
		}
		//아래
		for(int start = row + 1; start < N &&  start - row <= M - 1; start++) {
			cnt += table[start][col];
		}
		//왼쪽
		for(int start = col - 1; start >= 0 &&  col - start <= M - 1; start--) {
			cnt += table[row][start];
			
		}
		
//		System.out.println(row + " " +  col + " " + cnt);
		return cnt;
	}

	private static int xSearch(int row, int col, int[][] table, int N, int M) {
		// TODO Auto-generated method stub
		int cnt = table[row][col];
		// 오른위
		for(int start = 1; start < M   &&  row - start >= 0 && col + start < N; start++) {
			cnt += table[row - start][col + start];
		}
		// 오른아래	
		for(int start = 1; start < M   &&  row + start < N && col + start < N; start++) {
			cnt += table[row + start][col + start];
		}
		// 왼아래
		for(int start = 1; start < M  &&  row + start < N && col - start >= 0; start++) {
			cnt += table[row + start][col - start];
		}
		// 왼위
		for(int start = 1; start < M  &&  row - start >= 0 && col - start >= 0; start++) {
			cnt += table[row - start][col - start];
		}
//		System.out.println(row + " " +  col + " " + cnt);
		return cnt;
	}
}
