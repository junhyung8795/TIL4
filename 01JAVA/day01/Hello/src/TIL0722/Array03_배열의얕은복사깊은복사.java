package TIL0722;

public class Array03_배열의얕은복사깊은복사 {
	public static void main(String[] args) {
		// 얕은 복사
		// 객체 내부의 참조형 변수는 원본 객체의 참조를 복사한다.
		// 원본 객체와 복사본이 같은 참조를 가리키므로 복사본을 수정하면
		// 원본에도 영향을 준다.

		// 깊은 복사
		// 객체의 모든 필드 값을 새로 복사
		// 독립적인 객체가된다. -> 한 객체가 다른 객체에 영향을 주지 않는다.
		// for문으로 하나씩 요소를 대입하거나
		// Arrays.copyOf, Arrays.copyOfRange, System.arrayCopy
		
	}
}
