import java.util.Arrays;
import java.util.Scanner;

public class Tree02_연습문제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		int V = sc.nextInt();//정점의 총 개수 1번부터 시작
		//V-1개의 간선이 들어온다! -> 한 줄로 들어옴
		int[][] tree = new int[V + 1][3]; // [0]왼자, [1]오자, [2]부모
		
		for(int i =0 ; i < V - 1; i++) {
			int p = sc.nextInt();
			int c = sc.nextInt();
			//부모의 번호가 작은 것부터 + 왼자부터 준다.
			//왼자부터 채우고는 싶은데
			//왼자가 들어있는지 아닌지 먼저 확인!
			if(tree[p][0] == 0) {
				tree[p][0] = c;//왼자 저장
			} else {
				tree[p][1] = c;//오자 저장
			}
			
			
			//부모 저장
			tree[c][2] = p;
		}//tree입력
		
		//입력확인
		for(int i = 1; i < V + 1 ; i++) {
			System.out.println(i + ": " + Arrays.toString(tree[i]));
		}
		
		
	}
	//전위순회
	static void  preOrder(int v) {
		if() {
			
		}
	}
	static 
	String input = "13 \r\n" + "1 2 1 3 2 4 3 5 3 6 4 7 5 8 5 9 6 10 6 11 7 12 11 13\r\n"
	+ "\r\n";
}
