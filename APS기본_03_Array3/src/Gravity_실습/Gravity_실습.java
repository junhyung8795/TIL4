package Gravity_실습;

import java.io.*;
import java.util.*;

public class Gravity_실습 {
	public static void main(String[] args) throws IOException, FileNotFoundException {
		System.setIn(new FileInputStream("input (4).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {
			//입력받기 상자의 개수
			int numberOfBox = Integer.parseInt(br.readLine());
			
			//boxArr에 수를 넣는다.
			String[] s = br.readLine().split(" ");
			int[] boxArr = new int[numberOfBox];
			int leftTestCol = numberOfBox - 1;
			for(int i = 0 ; i < numberOfBox; i++) {
				boxArr[i] = Integer.parseInt(s[i]);
				//가장 왼쪽에 붙어있는 박스열은 왼쪽에서 몇번째에 있을까
				if(boxArr[i] != 0 && leftTestCol ==  numberOfBox - 1) {
					leftTestCol = i;
				}
			}
			
			//leftTestCol이 만약 7이면 
			//7개가 쌓여 있으니 leftTestCol 오른쪽에서 7보다 큰애들이 몇개 있는지를 체크
			//7보다 큰 애들만큼 numberOfBox - (leftTestCol + 1)에서 빼준다.
			int answer = 0;
			for(int heightOfBox = 1; heightOfBox <= boxArr[leftTestCol]; heightOfBox++) {
				int jammingBox = 0;
				for(int row = leftTestCol + 1; row < numberOfBox; row++) {
					if(heightOfBox <= boxArr[row]) {
						jammingBox += 1;
					}
				}
				
				int candi = numberOfBox - (leftTestCol + 1) - jammingBox;
				answer = Math.max(candi, answer);
			}
			
			System.out.println("#" + (test_case + 1) + " " +answer);
		
			
		}

	}
}
