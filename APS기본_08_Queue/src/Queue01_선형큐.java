
class MyQueue{
	
}


public class Queue01_선형큐 {
	
	//배열 x 큐이다. 
	public static int[] queue = new int[10];
	public static int front = -1;//데이터 삭제 위치
	public static int rear = -1;//데이터 삽입 위치
	
	
	public static void main(String[] args) {
		enQueue(10);
		enQueue(20);
		enQueue(30);
		
		while(!isEmpty()) {
			System.out.println(deQueue());
		}
		
		System.out.println(deQueue());
	}
	
	

	//공백 체크
	public static boolean isEmpty() {
		return front == rear;
	}
	
	
	//포화 체크
	public static boolean isFull() {
		return rear == queue.length - 1;
	}
	
	
	//삽입
	public static void enQueue(int item) {
		//포화체크후 넣어야한다.
		if(isFull()) {
			System.out.println("포화상태여서 삽입이 불가");
			return;
		}
		
		//삽입로직
		//rear++;
		//queue[rear] = item;
		queue[++rear] = item;
		
		
		
		
	}
	
	
	//삭제(반환 타입은 큐에 넣고 빼는 타입과 동일하다!)
	public static int deQueue() {
		//공백검사!
		if(isEmpty()) {
			System.out.println("아무 값이 없어서 꺼낼 수 없습니다.");
			return -1;//-1이라는 값이 내가 사용할 값일 수도 있어 주의해야한다.
		}
		
		return queue[++front];//실제로 데이터를 지운 것은 아니다.
		
	}
	
	
	
	
	
	
	
	//큐를 초기화하는 메서드(굳이 안해도되긴하다.)
	public void createQueue(int size) {
		queue = new int[size];
		front = -1;
		rear = -1;
	}
}
