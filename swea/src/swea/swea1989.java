package swea;

import java.io.*;
import java.util.*;

public class swea1989 {
	public static void main(String[] args) throws IOException, FileNotFoundException{
		System.setIn(new FileInputStream("input (5).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			String text = br.readLine();
			boolean isOk = true;
			//양 끝의 문자들을 비교해서
			//만약 하나라도 일치하지 않는다면 회문이 아니므로
			//isOk를 false로 만든다.
			for(int i = 0 ; i < text.length() / 2; i++) {
				if(text.charAt(i) != text.charAt(text.length() -1 - i)) {
					isOk = false;
					break;
				}
			}
			
			if(isOk) {
				System.out.printf("#%d %d",t + 1, 1);
			} else {
				System.out.printf("#%d %d",t + 1, 0);
			}
			System.out.println();
		}
	}
}
