import java.util.Stack;

public class Stack01_API {
	public static void main(String[] args) {
		
		
		Stack<Integer> stack = new Stack<>();
		
		//주요메서드
		//1.push
		int result = stack.push(10);
		System.out.println(result);
		stack.push(20);
		stack.push(30);
		
		//2. pop\
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
//		System.out.println(stack.pop()); 언체크드 예외가 터짐. 런타임에 터지는 에러다.
		
		
		//무작정 빼면 안된다. 비어있는지 먼저 체크해야한다.
		//3. isEmpty()
		System.out.println(stack.isEmpty());
		//안에 있는거 전부 빼라
		stack.clear();
//		stack.push(100);
		
		while(!stack.isEmpty()) {
			stack.pop();
		}
		
		
		
		while(stack.size() > 0) {
			stack.pop();
		}
		
		System.out.println(stack.size());
		
	
		//4.peek
		stack.push(100);
		stack.push(200);
		System.out.println(stack.peek());
		
		
		
		
		
		
		
		
	}
}
