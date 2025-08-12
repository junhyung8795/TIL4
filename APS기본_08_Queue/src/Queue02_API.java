import java.util.*;


public class Queue02_API {
	public static void main(String[] args) {
		//Queue 인터페이스
		//구현체로
		//1. LinkedList
		//2. ArrayDeque 두가지를 쓴다.
		Queue<String> q = new LinkedList<>();
		
		
		//
//		q.add("이병현");
//		q.offer("박지우");
		
		//삭제
//		q.remove();//공백 상태에서 꺼내면 예외가 터진다.
//		q.poll();//공백 상태에서 꺼내면 null이 나온다. 중요!
		
		//조회
//		q.element();//에외 터짐
		System.out.println(q.peek());//null이 나온다.
		
		
		//add, remove, element: 예외를 발생시키는 조합
		//offer, poll, peek: null값을 반환하는 조합
		
	}
}
