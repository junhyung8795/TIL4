
public class BruteForceSearchTest {
	private static int bruteForce(String p, String text) {
		// 패턴의 길이랑 텍스트의 길이

		int M = p.length(); //패턴의 길이
		int N = text.length(); //텍스트 길이
		
		//for문으로 부르트포그 로직 구현
		for(int i =0 ; i < N - M + 1; i++) {
			int j = 0;
			for(j = 0; j < M; j++) {
				//문자비교 text[i] <-> p[j]
				//해당 패턴 매칭 실패! -> 다음 매칭으로 가야하므로 break
				if(text.charAt(i + j) != p.charAt(j)) {
					break;
				}
			}
			//패턴 매칭 성공 케이스!
			if(j == M) {
				return i; //i 인덱스를 반환
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		//찾을 패턴
		String p = "is";
		//전체 문자열
		String text = "cat is animal";
		
		//무식한 조회 방법 : bruteforcesearch 메서드 만들어보기
		int idx = bruteForce(p, text);
		System.out.println(idx);
	}

}
