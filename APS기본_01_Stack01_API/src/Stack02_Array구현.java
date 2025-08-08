
public class Stack02_Array구현 {
	// 베열을 이용한 구현 -> 고민포인트 몇칸으로 만들것인가? 배열의 크기를 정해야한다.
	// -> 10만에서 100만 사이의 수를 넣어도된다.

	static String[] stack = new String[10];
	static int top = -1; // - 1로 초기화 인덱스 밖이다. //공백상태라는걸 나타낸다.

	public static void main(String[] args) {

	}

	// push
	static boolean push(String item) {
		// 배열이므로 가득 차 있는지 체크할 필요가 있다.
		if (isFull()) {
			// 가득 차 있으므로 작업 진행이 불가
			// stack의 크기를 2배로 늘려서 복사해두던가
			// 못한다고 쳐내자!
			System.out.println("가득 찼다");
			return false;
		}

		//top을 하나 증가시키고 item넣기
//		top += 1;
//		stack[top] = item
		//위 두 줄을 하나로 합침
		stack[++top] = item;

		return true;
	}
	
	//pop
	static String pop() {
		//배열이 아니더라도 이 연산은 해봐야 돼
		if(isEmpty()) {
			
			System.out.println("스택이 비어있어서 뺄 수 없다.");
			return null;
		}
		
		//꺼내자
//		String result = stack[top];
//		top -= 1;
//		return result;
		//stack 에서 값을 꺼낸다고 해서 배열에 있는 값을 지우지 않는 이유는
		//만약 push를 하면 top에 +1을 하고 값을 덮어버릴 것이기 때문에
		return stack[top--];
	}
	
	
	static boolean isEmpty() {
		return top == -1;
	}
	

	// isFull()
	static boolean isFull() {
		if(top == stack.length - 1) {
			return true;
		}
		return false;
	}
}
