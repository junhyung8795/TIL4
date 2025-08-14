package swea;


import java.util.*;
import java.io.*;

class yesterday {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테케 입력
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");

			// int[]배열 입력
			int[] numArr = new int[N];
			for (int i = 0; i < numArr.length; i++) {
				numArr[i] = Integer.parseInt(s[i]);
			}

			// i, j에 해당하는 모든 숫자 조합을 Set에 모아보자
			// 두 수를 곱했을 때 중복값이 나올 수 있으니 Set에 넣는다.
			HashSet<Integer> set = new HashSet<>();
			for (int i = 0; i < N - 1; i++) {
				for(int j = i + 1; j < N; j++) {
					set.add(numArr[i] * numArr[j]);
				}
			}
			
			int answer = 0;
			int maxNumber = 0;
			for(Integer a: set) {
				char[] charArrNum = String.valueOf(a).toCharArray();
				for(int i = 0; i < charArrNum.length - 1; i++) {
					if(charArrNum[i] -'0' > charArrNum[i + 1] - '0') {
						break;
					}
					answer++;
					maxNumber = Math.max(maxNumber, a);
				}
			}
			
			System.out.println("#" + t + " " +maxNumber);
			
			

		}
	}
}