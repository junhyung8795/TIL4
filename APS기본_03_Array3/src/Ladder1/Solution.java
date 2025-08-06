package Ladder1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	static String[][] table;
	static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}};
	public static void main(String[] args) throws FileNotFoundException, IOException {
		System.setIn(new FileInputStream("input.txt"));
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      

      //입력받기
      
      //테케의 개수는 10개
      for(int t = 0; t < 10; t++){
    	  //테이블 입력 받기
    	  int T = Integer.parseInt(br.readLine());
    	  table = new String[100][100];
          for(int i = 0; i < 100; i++){
              String[] s = br.readLine().split(" ");
              table[i] = s;
          }
          
          
          
          //그러면 이제는 각 열을 탐색하면서 시작점을 찾기
          //시작점에서 부터 dirs를 순회하면서
          //각 dir을 더한 dr dc 지점이 0이면 못가니
          //그때는 아래로 내려가고(아래로 내려갈 수 있는지 체크) 
          //아니라면 오른쪽, 왼족으로 옮기고 다시 내려가고를 반복
          //그래서 만약에 더이상 내려갈 수없고 가장 밑인데 2라면? 그게 정답
          for(int startCol = 0; startCol < 100; startCol++) {
        	  if(table[0][startCol].equals("1")) {
        		  boolean result = goDown(0, startCol);
        		  if (result) {
        			  System.out.println("#" + (t + 1) + " "+ startCol);
        		  }
        	  }
          }  
      }	
	}

	private static boolean goDown(int startRow, int startCol) {
		int r = startRow;
		int c = startCol;
		boolean[][] visited = new boolean[100][100];
		visited[r][c] = true;
		
		while(true) {
			if(r == 99) {
				if(table[r][c].equals("2")) {
					return true;
				} else {
					return false;
				}
			}
			for(int[] dir: dirs) {
				int dr = dir[0] + r;
				int dc = dir[1] + c;
				if(dr >= 0 && dr < 100 && dc >= 0 && dc < 100 ) {
					if(visited[dr][dc] == false && !table[dr][dc].equals("0")) {
						visited[dr][dc] = true;
						r = dr;
						c = dc;
//						System.out.println(r + " " + c);
						break;
					}
				}
			}
		}
		
	}
}


