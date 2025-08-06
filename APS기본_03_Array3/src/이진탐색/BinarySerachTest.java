package 이진탐색;

public class BinarySerachTest {

	public static void main(String[] args) {
		// 정렬이 돼있는 배열
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 1000, 10000 };
			
		binarySearch(arr, 8);
	}

	private static int binarySearch(int[] arr, int target) {
		// TODO Auto-generated method stub
//		일상생활 예시: 1~100 UP/DOWN 게임!
//		- 친구 1~100 사이의 수 하나를 생각하기...! (예: 72)
//		- 나: 50!   -> 친구 : UP!  (51~100)
//		- 나: 75!   -> 친구 : DOWN! (51~74)
//		- 나: 62!   -> 친구 : UP!   (63~74)
//		- 나: 69!   -> 친구 : UP!   (70~74)
//		- 나: 72!   -> 친구: 정답!!!!
		//우리가 탐색할 범위의 왼쪽, 오른쪽 범위
		//왼쪽 범위 left, 오른족 범위 right
		int left = 0;               //배열의 시작 인덱스
		int right = arr.length - 1; //배열의 마지막 인덱스
		
		//반복문으로 우리가 외치는 수가 target이 되는 경우 종료!
		while(left <= right) {
			//우리 범위 중간값 계산
			int middle = (left + right) / 2;
			
			//친구에게 UP/DOWN/정답일때 로직을 달리해야함
			//정답일 경우 = 내가 원하는 target을 배열에서 찾았을 경우
			if(arr[middle] == target) {
				return middle;//인덱스 반환
			}
			
			if(arr[middle] < target) { //1. UP
				left = middle + 1; //오른쪽 절반 탐색
			} else { //2. DOWN
				right = middle - 1;//왼쪽 절반 탐색
			}
		}
		return -1;
	}

}
