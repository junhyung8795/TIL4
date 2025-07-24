package TIL0722;
import java.util.Arrays;

public class Array02_배열의순회 {

	public static void main(String[] args) {
		int[] intArray = { 1, 3, 5, 7, 9 };

		for (int i = 0; i < intArray.length; i++) {
			System.out.print(intArray[i] + " ");
		}

		// for each -> 인덱스말고 요소에 접근할 수 있는 변수 제공
		// read only! 읽기만하고 변수를 변경하진 않는다.
		for (int x : intArray) {
			// System.out.println(x * 2);
			// x = x* 2;
			x *= 2;
		}

		System.out.println(Arrays.toString(intArray));
		
		for (int i = 0; i < intArray.length; i++) {
			//인덱스에 접근해서 하면 for-each와 다르게 배열 안의 값이 변경된다!
			intArray[i] *= 2; 
			System.out.print(intArray[i] + " ");
		}
	
		
	}

}
