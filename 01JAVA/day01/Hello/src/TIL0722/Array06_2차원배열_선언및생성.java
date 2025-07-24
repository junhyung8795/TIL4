package TIL0722;

import java.util.Arrays;

public class Array06_2차원배열_선언및생성 {

	public static void main(String[] args) {
		// 다차원배열
		// 배열안에 또다른 배열을 포함하는 구조
		// 일반저긍로 2차원이 많지만 3차원 이상도 가ㅣ능
		// 표 형태 혹은 복잡한 계층 구조를 표현할 때 유용
		// 배열 객체의 참조값을 요소로 갖는다.
		// 2차원 배열은 배열요소로 1차원 배열의 참조를 가짐.
		// 이와 비슷하게 n차원 배열은 n - 1차원 배열의 참조를 가진다.
		// 2차원 배열의 각 요소는 길이가 일정할 필요가 없다!
		// 각 요소의 끝자리 몇개는 없어도 된다. 4,5,6인 길이인 배열이 요소로 들어가도된다.
		// 하지만 배열은 연속된 메모리 공간을 할당받기에 중간에 값이 비면 안된다.

		// 1. 크기 지정
		int[][] arr4 = new int[2][3]; // 행: 2, 열: 3
		System.out.println(Arrays.toString(arr4[0]));
		
		// 2차원 배열 출력
		for (int i = 0; i < arr4.length; i++) {
			for (int j = 0; j < arr4[i].length; j++) {
				System.out.print(arr4[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("-------------");
		for (int[] a : arr4) {
			System.out.println(Arrays.toString(a));
		}

		System.out.println("-------------");
		System.out.println(Arrays.deepToString(arr4));
		
		
		//-------------------------------------------------------------
		// 2. 비정형 배열, 1차원 배열의 개수만 지정하고, 크기를 지정하지 않을 수 있다.
		int[][] arr5 = new int[5][];

		arr5[0] = new int[] { 1, 2, 3 };
		System.out.println(Arrays.deepToString(arr5));
		
		int[][] arr6 = new int[][] {{1,2,3}, {4,5,6}, {7,8,9}};
		System.out.println(Arrays.deepToString(arr6));
		
		//가능하다. null배열을 넣는 대신에 포맷을 맞춰주려고 종종 쓴다.
		int[] arr7 = new int[0];
		
		
		//널포인트익셉션
		//int[][] arr = new int[2][]
		//arr[1][1] = 100;을 하면 arr[1]이 null이다.
		//null에 접근하여 1번 인덱스에 값을 넣기에 널포인트익셉션
	}

}
