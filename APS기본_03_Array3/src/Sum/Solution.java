package Sum;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {
			// 테케 번호 받기
			int T = Integer.parseInt(br.readLine());

			// 테이블 입력 받기
			int[][] table = new int[100][100];
			for (int i = 0; i < 100; i++) {
				String[] s = br.readLine().split(" ");
				for (int j = 0; j < 100; j++) {
					table[i][j] = Integer.parseInt(s[j]);
				}
			}

			// 행을 더해서 최댓값
			int rowMax = plusAllOfRow(table);

			// 열을 더해서 최댓값
			int colMax = plusAllOfCol(table);

			// 대각선 더해서 최댓값
			int 대각선Max = plusAllOf대각선(table);

			int answer = 0;
//			System.out.println(rowMax + " : rowMax");
//			System.out.println(colMax + " : colMax");
//			System.out.println(대각선Max + " : 대각선Max");

			answer = Math.max(대각선Max, answer);
			answer = Math.max(rowMax, answer);
			answer = Math.max(colMax, answer);

			System.out.println("#" + test_case + " " + answer);
		}

	}

	private static int plusAllOf대각선(int[][] table) {
		int candi1 = 0;
		for (int i = 0; i < 100; i++) {
			candi1 += table[i][i];
		}

		int candi2 = 0;
		for (int i = 0; i < 100; i++) {
			candi2 += table[i][99 - i];
		}

		return Math.max(candi1, candi2);
	}

	private static int plusAllOfCol(int[][] table) {
		// TODO Auto-generated method stub
		int candi = 0;

		for (int col = 0; col < 100; col++) {
			int candi2 = 0;
			for (int row = 0; row < 100; row++) {
				candi2 += table[row][col];
			}
			candi = Math.max(candi, candi2);
		}

		return candi;
	}

	private static int plusAllOfRow(int[][] table) {
		int candi = 0;

		for (int row = 0; row < 100; row++) {
			int candi2 = 0;
			for (int col = 0; col < 100; col++) {
				candi2 += table[row][col];
			}
			candi = Math.max(candi, candi2);
		}

		return candi;

	}
}
