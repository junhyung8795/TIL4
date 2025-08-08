package swea;
import java.io.*;
import java.util.*;

//8931. 제로
public class swea8931 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("sample_input (3).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0 ; t < T; t++) {
			int K = Integer.parseInt(br.readLine());
			
			
			
			
			Stack<Integer> stack = new Stack<>();
			//입력을 하나씩 받으면서 검사를 한다.
			//0이 아닌 정수가 들어오면 stack에 넣고
			//아니라면 stack에 있는 수를 하나 뺀다.
			//그런데 0 이 나오는 경우는 모두 stack에 수가 있다고 가정하니
			//stack이 비어있는지 검사는 안해도된다.
			for(int i = 0 ;i < K; i++) {
				int number = Integer.parseInt(br.readLine());
				if(number != 0) {
					stack.push(number);
				} else {
					stack.pop();
				}
			}
			
			
			//넣고 뺀 작업 후 스택에 남아 있는 수들을 전부 더하고 출력
			int total = 0;
			while(!stack.isEmpty()) {
				total += stack.pop();
			}
			System.out.println("#" + (t + 1) +" " + total);
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
	}
}
