package swea;
//1216. [S/W 문제해결 기본] 3일차 - 회문2

import java.io.*;
import java.util.*;

public class swea1216 {
	static char[][] table;
	private static boolean rowTest(int standard) {
		for(int row = 0; row < 100; row++) {
			for(int col = 0; col < 100 - standard + 1; col++) {
				boolean isOk = true;
				for(int idx = 0; idx < standard / 2; idx++) {
					if(table[row][col + idx] != table[row][col + standard - 1 - idx]) {
						isOk = false;
						break;
					}
				}
				if(isOk == true) {
					return true;
				}
			}
		}
		return false;
		
	}
	private static boolean colTest(int standard) {
		for(int col = 0; col < 100; col++) {
			for(int row = 0; row < 100 - standard + 1; row++) {
				boolean isOk = true;
				for(int idx = 0; idx < standard / 2; idx++) {
					if(table[row + idx][col] != table[row + standard - 1 - idx][col]) {
						isOk = false;
						break;
					}
				}
				if(isOk == true) {
					return true;
				}
			}
		}
		return false;
		
	}
	public static void main(String[] args) throws FileNotFoundException, IOException{
		System.setIn(new FileInputStream("input (6).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//최대 10회 실행하니 t를 0부터 9까지 돌린다.
		for(int t = 0; t < 10; t++) {
			int test_case = Integer.parseInt(br.readLine());
			
			
			
			
			
			//테이블 입력을 받는다.
			table = new char[100][100];
			for(int i = 0; i < 100; i++) {
				table[i] = br.readLine().toCharArray();
			}
			System.out.println();
			//최대의 펠린드롬 길이를 구해야하니 길이가 100일때부터 시작해서 탐색한다.
			//그래서 해당 길이의 펠린드롬이 발견되면 바로 break하고 답을 프린트
			for(int standard = 100 ; standard >= 1; standard--) {
				boolean rowTestResult = rowTest(standard);
				boolean colTestResult = colTest(standard);
				if(rowTestResult || colTestResult) {
					System.out.printf("#%d %d", test_case, standard);
					System.out.println();
					break;
					
				}
			}
			
			
		}
		
	}

}
