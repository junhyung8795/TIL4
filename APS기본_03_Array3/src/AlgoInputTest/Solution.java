package AlgoInputTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	
	/**
	 * 우리가 페이지를 찾기 위한 이진 탐색 메서드
	 * @param p 페이지 전체 쪽수
	 * @param pa 찾아야할 페이지 쪽
	 * @return 탐색횟수 
	 */
	private static int binarySearch(int p, int page) {
		// TODO Auto-generated method stub
		int left = 1, right = p;
		int cnt = 0;
		while(left <= right) {
			cnt++;
			
			// 우리가 찾고자 하는 값(중간값)
			int c = (left + right) / 2;
			
			//내가 찾고자하는 페이지가 해당되는 페이지와 같다면 종료
			if(c == page) {
				return cnt;
			}
			
			//up/down
			if(c < page) {
				left = c;
			} else {//c > page
				right = c;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		//사용자의 입력으로 파일로 일겅서 입력 처리
		System.setIn(new FileInputStream("sample_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		//테스트 케이스 수 TC
		int TC = sc.nextInt();
		
		//테스트 케이스 수만큼 반복
		for(int test_case = 1; test_case <= TC; test_case++) {
			
			//입력
			// 전체 페이지 수 P
			int P = sc.nextInt();
			int Pa = sc.nextInt();
			int Pb = sc.nextInt();
			
			//로직 해당 쪽 번호를 탐색을 수행하게 된 횟수..!(바이너리 서치)
			int countA = binarySearch(P, Pa);//A사람의 페이지 탐색 횟수
			int countB = binarySearch(P, Pb);//B사람의 페이지 탐색 횟수
				
			
			//출력(탐색 횟수에 따라 횟수가 적은 쪽이 승리!)
			if(countA < countB) {
				//A가 승리
				System.out.println("#" + test_case + " A");
			} else if (countA > countB) {
				//B가 승리
				System.out.println("#" + test_case + " B");
			} else {
				//무승부
				System.out.println("#" + test_case + " O");
			}
			
		}
	}

	
}
