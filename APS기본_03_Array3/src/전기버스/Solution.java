
package 전기버스;

import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException, FileNotFoundException {
		System.setIn(new FileInputStream("sample_input (1).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		label:
		for (int t = 0; t < T; t++) {
			String[] s = br.readLine().split(" ");
			int K = Integer.parseInt(s[0]);
			int N = Integer.parseInt(s[1]);
			int M = Integer.parseInt(s[2]);

			// 충전소위치 입력 받기
			// 0부터 N까지니 전체길이가 N + 1인 배열 생성
			// 해당 배열에서 충전소가 있는 부분은 1로 초기화
			String[] s1 = br.readLine().split(" ");
			int[] wholeMap = new int[N + 1];
			for (int i = 0; i < M; i++) {
				int chargeStationIndex = Integer.parseInt(s1[i]);
				wholeMap[chargeStationIndex] = 1;
			}

			// 목표정류장을 K가 엄청 커서 먼저 갈 수 있다면
			// cnt =0을 출력
			if (K >= N) {
				System.out.printf("#%d %d\n", t + 1, 0);
				continue;
			}

			// 현재위치 + K보다 작거나 같은 위치 중에 가장 멀리 있는 충전소를 찾아야한다.
			// 그런데 중간에 이미 i가 N을 지나고 있다면? -> current + K가 N을 넘었다면
			// 이미 도착했기에 cnt를 더하지 않고 프린트 해야한다! -> while문 탈출해서 cnt 출력
			// 그게 아니라면 currentPos + K를 넘지 않는 가장 멀리 있는 충전소를 찾아야한다.
			int currentPos = 0;
			int cnt = 0;
			while (currentPos + K < N) {
				int candiPos = 0;
				for (int i = currentPos; i <= currentPos + K; i++) {
					System.out.println(currentPos + " " + (currentPos + K));
					if (wholeMap[i] == 1) {
						candiPos = i;
					}
				}
				if (candiPos == 0) {
					System.out.printf("#%d %d\n", t + 1, 0);
					continue label;
				}
				currentPos = candiPos;
				cnt++;
				System.out.println(currentPos + " " + "결정된 위치");
			}

			System.out.println(cnt);

		}
	}
}
