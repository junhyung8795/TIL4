package swea;

import java.util.Arrays;

public class SelectionSort {
	// 삽입정렬: 아직 정렬되지 않은 원소들 중에 최솟값을 찾아 앞에 배치(교환)
	private static void selectionSort(int[] arr) {
		final int n = arr.length;
		
		for(int i = 0; i < n - 1; i++) {
			//최솟값을 인덳를 임의로 i로 지정
			int minIdx = i;
			// i + 1에서 n이전 까지 있는 모든 구간. [i + 1, n)
			for(int j = i + 1; j < n ; j++) {
				
				//두 개의 값 [midIdx] <-> [j] 비교해서 교환
				if(arr[minIdx] > arr[j]){
					minIdx = j;
				}
			}
			
			//최솟값을 가지고 있는 minIdx가 탄생
			if(minIdx != i) { //i와  minIdx가 같으면 교환할 필요가 없다.
				//최솟값과 현재 위치(i)를 교환
				int temp = arr[i];
				arr[i] = arr[minIdx];
				arr[minIdx] = temp;
			}
			
		}

	}

	public static void main(String[] args) {
		int[] arr = { 4, 2, 1, 6, 8, 9, 7, 3 };

		System.out.println(Arrays.toString(arr));

		// 버블 정렬을 실행..!(메서드 작성)
		bubbleSort(arr);

		System.out.println(Arrays.toString(arr));
	}
}
