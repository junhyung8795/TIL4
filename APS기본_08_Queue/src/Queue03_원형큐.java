import java.util.Arrays;

public class Queue03_원형큐 {

	// 배열처럼 보이지만 사실은 원형큐
	// 한칸은 비워서 구분한다.(포화/ 공백)
	public static String[] cQ = new String[5];
	public static int front = 0;
	public static int rear = 0;

	public static void main(String[] args) {
		enQueue("준형");
		deQueue();
		
		//데이터가 있는 것처럼 보이지만 사실은 없는 것이다.
		System.out.println(Arrays.toString(cQ));
		
		while(!isEmpty()){
			System.out.println(deQueue());
		}
		
		
	}

	// 공백은 선형쿠와 동일!
	public static boolean isEmpty() {
		return front == rear;
	}

	// 포화(rear가 들어갈 다음 위치와 front가 동일하다면 포화상태)
	public static boolean isFull() {
		return front == (rear + 1) % cQ.length;
	}

	// 삽입
	public static void enQueue(String item) {
		// 포화체크
		if (isFull()) {
			System.out.println("가득 차 있다!");
			// 베열의 크기를 2배로 키우고 안에 내용을 복사해서 넣자.
			return;
		}

		// rear 증가시킬건데 -> 순환하는 것도 고려해야함.
		rear = (rear + 1) % cQ.length;
		cQ[rear] = item;
	}
	
	
	//삭제 
	public static String deQueue(){
		if(isEmpty()) {
			System.out.println("공백상태라서 꺼낼 수 없다.");
			//배열의 크기를 줄이자
			return null;
		}
		
		front = (front + 1) % cQ.length;
		//실제 데이터를 지우는 가? -> 실제 데이터를 지우는 건 아니다.
		return cQ[front];
	}
}
