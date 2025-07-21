
public class 논리연산자 {
	public static void main(String[] args) {
		//논리연산자 &&(ANd), ||(OR)
		int score = 70;
		//앞이 참이고 &&이니 뒤에도 연산 필요! 뒤가 거짓일 수 있으니
		System.out.println(score > 70 && score++ < 90); // true score > 70 포함시 false가 됨
		System.out.println(score); // 70이 출력됨. 뒤에 있는게 연산 안돼서
		
		//앞에 값이 참이면 뒤를 보지 않아도 참이 된다. short circuit evaluation -> 단락평가
		//단락 평가: 이미 평가에 대한 결과 (논리연산)이 명백히 나오면 뒤의 연산을 더 진행하지 않고 평가.
		score = 70;
		System.out.println(score < 70  || score++ < 90); //true
		System.out.println(score);//뒤까지 평가를 진행하기에 score = 71이됨/.
	}
}
