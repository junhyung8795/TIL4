package swea;

import java.util.Arrays;

public class bubbleSort {
	//버블정렬: 인접한 두개의 원소를 비교하여 큰 값을 뒤로 보내는 과정을 반복한다.
	private static void bubbleSort(int[] arr) {
		final int n = arr.length;
		
		//교환이 발생하지 않으면 정렬이 이미 완료됨!
		boolean swapped = false;
		
		//n개의 원소를 순회하며 n번 이전값과 이후값을 비교하는 과정
		for(int i = 0 ; i < n; i++) {
			for(int j = 0; j < n - i - 1; i++){
				if(arr[j] < arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}
			if(!swapped) {
				break;
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
