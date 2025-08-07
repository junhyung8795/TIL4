package swea;
import java.util.*;
import java.io.*;

public class swea1213 {
	private static int bruteForceSearching(String pattern, String text) {
		int result = 0;
		int lengthOfPattern = pattern.length();
		int lengthOfText = text.length();
		//패턴이 평문에 들어있는 횟수를 저장할 cnt변수
		int cnt = 0;
		
		//text의 각 인덱스를 시작점으로 해서 패턴의 문자들을 하나하나 비교
		for(int textIdx = 0; textIdx < lengthOfText - lengthOfPattern + 1
				;textIdx++) {
			//일치하는지 여부 판단을 위한 isOk
			boolean isOk = true;
			for(int patternIdx = 0; patternIdx < lengthOfPattern; patternIdx++) {
				if(text.charAt(patternIdx + textIdx) != pattern.charAt(patternIdx)) {
					isOk = false;
					break;
				}
			}
			//만약 isOk가 false면 그냥 넘어가고
			//isOk가 true면 cnt++
			if(isOk == false) {
				continue;
			} else {
				cnt++;
			}
		}
		
		return cnt
				;	
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		System.setIn(new FileInputStream("test_input.txt"));
        Scanner sc = new Scanner(System.in);
        for(int t= 0; t < 10; t++){
        	int test_case = sc.nextInt();
            sc.nextLine();
            String pattern = sc.nextLine();
            String text = sc.nextLine();
            
            System.out.println(bruteForceSearching(pattern, text));
            
        }
	}

}
