
public class Array08_2차원배열순회 {
	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 1, 2, 3 } };
		
		//행 우선 순회 방식, 정방향
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		//행 우선순회 방식, 역방향
		//1. for문 조건 건드리는 방식
		
		
		//2. index를 건드리는 방식
		
		//열우선순회, 정방향
		for(int j = 0 ; j < arr[0].length; j++) {
			for(int i = 0; i < arr.length; i++) {
				System.out.print(arr[i][j] +  " ");
			}
			System.out.println();
		}
		
		//열 우선순회, 역방향 조건/인덱스 건드리기
		
	}
}
