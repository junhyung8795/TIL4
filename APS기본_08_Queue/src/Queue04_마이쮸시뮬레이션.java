import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class Queue04_마이쮸시뮬레이션 {
	static class Person{
		static int pNumber = 1;
		int num; //사람의 번호
		int cnt; //가져갈 수 있는 마이쮸
		@Override
		public String toString() {
			return "Person [num=" + num + ", cnt=" + cnt + "]";
		}
		
		public Person() {
			this.num = pNumber++;
			this.cnt = 1;
		}
		public Person(int num) {
			super();
			this.num = num;
			this.cnt = 1;
		}
		public Person(int num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int ans = 0;
			int N = sc.nextInt();//이번에 나누어줄 마이쮸의 양
			int pNum = 1;
			//Q를 통해서 관리를 하겠다.
			//1. 사람의 번호
			//2. 가져갈 수 있는 마이쮸의 개수
			//둘다 정수니까 int[]배열을 넣자
//			Queue<int[]> q = new LinkedList<>();
			Queue<Person> q = new LinkedList<>();
			
//			q.offer(new Person());
			q.offer(new Person(pNum++));
//			q.offer(new Person(pNum++, 1));
			
			while(N > 0) {
				Person p = q.poll();
				System.out.println(N + "개 남음");
				N -= p.cnt;
				if(N <= 0) {
					//마지막 마이쮸까지 가져갔다.
					ans = p.num;
					System.out.println(p.cnt);
					break;
				}
				
				//위 조건이 아닌 경우에는
				//p.cnt++;
//				q.offer(p); //p 새로 생성한게 아니라 p를 다시 넣어서 줄을 세움.
				q.offer(new Person(p.num, p.cnt + 1));//위 두 줄을 이렇게도 쓸 수 있다.
				//단 다시 세우면 원래 받아야했던 cnt보다 1개 더 받아가기로 했어서 p.cnt++;
				//////////
				//새로운 사람이 와서 줄을 선다!
				q.offer(new Person(pNum++));
			}//나누어주기 끝
			System.out.println("#" + tc +  " " + ans);
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
	}
}
