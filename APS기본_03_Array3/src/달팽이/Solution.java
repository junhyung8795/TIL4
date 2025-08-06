package 달팽이;

import java.io.*;
import java.util.*;

public class Solution{
    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
	public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0 ; t < T; t++){
            int N = Integer.parseInt(br.readLine());
        	int[][] table = new int[N][N];
            int current = 1;
            
            int row = 0;
            int col = -1;
            //로직
            //각 방향을 탐색하면서 각 방향의 우선순위를 통해서 범위 바깥을 나가지 않으면 해당 칸에  current를 쓴다
            while(current <= N * N){
            	for(int[] dir: dirs){
                    int r = dir[0] + row; 
                    int c = dir[1] + col;
                    if(r >= 0 && r < N && c >= 0 && c < N && table[r][c] == 0){
                    	table[r][c] = current++;
                    	row = r;
                    	col = c;
                        break;
                    }
                    
            	}
            }
            
         
            
            //출력
            System.out.printf("#%d", t + 1);
            System.out.println();
            for(int i = 0 ; i < N; i++){
            	for(int j = 0 ; j < N; j++){
                	System.out.print(table[i][j] +" ");
                }
                System.out.println();
            }
            
        }
    }
}