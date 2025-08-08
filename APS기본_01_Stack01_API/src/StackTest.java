class Stack {
	private int[] stack;
	private int top;
	private int size;

	public Stack(int size) {
		stack = new int[size];
		top = -1;
		this.size = size;
	}

	// isEmpty() 요소가 하나도 들어잇지않으면 true반환
	public boolean isEmpty() {
		return this.top == -1;
	}

	// isFull() 스택에 요소가 꽉차 있는 상황
	public boolean isFull() {
		return this.top == size - 1;
	}

	// peek 가장 마지막 원소를 가리켜야한다.
	public int peek() {
		return stack[top];
	}

	public boolean push(int item) {
		// top의 위치를 한칸 올리고(증가)
		// 그 위치에 item을 할당한다.

		// 단 공간이 있는지 봐야함.
		if (isFull()) {
			return false;
		}
		top++;
		stack[top] = item;
		return true;
	}

	// pop 스택에서 원소를 제거하고 반환한다.
	public int pop() {
		//비어있으면 팝 못하게 막기
		if(isEmpty()) {
			
//			throw new RumtimeException("스택 언더플로우");
			return -1;
		}
		
//		int temp = stack[top];
//		top--;
		return stack[top--];
	}

}

public class StackTest {
	public static void main(String[] args) {
		Stack stack = new Stack(5);
			
		//스택의 1 2 3 4 5 6까지 넣고
		for(int i = 1; i <= 6; i++) {
			stack.push(i);
			System.out.print(i + "->");
		}
		System.out.println();
		System.out.println("--------------");
		//스택에서 6번 값을 빼보자
		for(int i = 1 ; i <= 6; i++) {
			int result = stack.pop();
			System.out.print(result + "->");
		}
		
		
		
		
		
		
		
		
		
		
	}
}
