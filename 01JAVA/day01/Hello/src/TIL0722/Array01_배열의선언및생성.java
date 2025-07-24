package TIL0722;
import java.util.Arrays;

public class Array01_배열의선언및생성 {

	public static void main(String[] args) {
		// 배열을 선언
		int[] arr1; // 권장
		int arr2[]; // 비권장

		// 배열을 초기화. 기본적으로 0이 채워져 있다.
		int[] arr3 = new int[10];
		String[] arr4 = new String[5];
		System.out.println(Arrays.toString(arr3));
		System.out.println(Arrays.toString(arr4));

		// 길이를 직접 명시할 수 없다.
		int[] arr5 = new int[] { 1, 2, 3, 4, 5 };// []안에 10을 넣어 [10]을 쓰면 오류가 난다.
		System.out.println(Arrays.toString(arr5));

		// 선언과 동시에 할당이 이루어질때만 {}안에 문자열들을 넣는 형태가 가능하다.
		String[] arr6 = { "손지민", "신윤수", "유현진" };
		System.out.println(Arrays.toString(arr6));

		// 가능!
		arr6 = new String[] { "권인범", "우수연", "김민재" };

		// 불가능!
		//arr7={"이서연","안태리","박정민"}; 재할당 불가능.
		
		//런타임오류! 10번째 인덱스에 접근한다고하면 문법적 오류는 없으나
		//실제로는 인덱스 범위를 벗어났기 때문에 ArrayIndexOutOfBoundsException이 터진다.
		System.out.println(arr6[10]);

	}

}
