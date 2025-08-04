package swea;

import java.util.Arrays;

public class CountingSort {
	public static void main(String[] args) {
		int[] arr = { 4, 2, 1, 6, 8, 9, 7, 3 };

		

		//카운팅 정렬 실시
		//우리가 수행하게될 배열의 원소 가장 큰 값 찾기..!
		//카운팅 배열을 (크기)선언
		int[] count = new int[10];
		
		//count[4]++;
		//count[2]++;
		//count[1]++;
		//2. 카운팅 배열에 개수 세기..!
		for(int v : arr) {
			count[v]++;
		}
		
		//안정정렬을 구현하기 위해
		//3. 카운팅 누적합 배열로 구하기
		for(int i = 1; i < 10; i++) {
			count[i] += count[i - 1];
		}
		
		//4. 결과 배열
		int[] result = new int[arr.length];
		//5. 원본 내열을 뒤에서부터 처리한다. 뒤에서 부터하면 요소가 복사본 배열의 뒤부터 들어가니
		//순서가 바뀌지 않아 안정정렬이 보장된다.
		for(int i = arr.length - 1; i >= 0; i--) {
			//원소를 넣을 위치를 찾는다.
			int value = arr[i];
			int idx = count[value];
			result[idx - 1] = value;
			count[value]--;
		}
		
		//정수하나만을 정렬하면 아래코드써도된다.
		//3-1. 최종적으로 누적된 값을 해당되는 인덱스 갯수마큼 출력
//		for(int i = 0; i < 10; i++) {
//			for(int j = 0; j < count[i]; j++) {
//				System.out.print(i + " ");
//			}
//		}
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(result));
	}
	
}
