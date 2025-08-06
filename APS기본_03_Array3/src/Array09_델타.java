
public class Array09_델타 {
	//상하좌우 정리를 해보자!
	static int[] dr = {-1, 1, 0, 0}; //행의 변화량dy
	static int[] dc = {0, 0, -1, 1}; //열의 변화량dx
	static int[][] drc = {{}, {}, {}, {}} // 2차원 배열. [dir][0], [dir][1]은 각각 행과 열의증가량
	public static void main(String[] args) {
		int N = 3;
		int[][] arr = new int[N][N];
		
		int r = 2;
		int c = 1;
		
		for(int d = 0 ; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
		
		
			//순회가능 여부를 확인
			//1. 내안에 들어오면 진행해
			if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
				System.out.println(arr[nr][nc]);
			}
		
		}
		
	}
}
