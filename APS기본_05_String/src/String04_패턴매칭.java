
public class String04_패턴매칭 {
	public static void main(String[] args) {
		String text = "This iss a book";
		String pattern = "iss";

	}

	// 찾는 순간 해당 위치의 인덱스를 반환 (없으면 -1을 반환한다.)
	public static int matchingFor(String t, String p) {

		// 길이를 뽑아냄.
		int N = t.length();
		int M = p.length();

		// for문을 두개 사용
		// 사작점을 고르는 for문과 시작점부터 본문과 패턴을 비교하는 for문
		// 단 바깥 for문은 시작점이 될 수 있는 index가 맨끝가지는 되는건 아니다.
		// index 를 0에서 부터 12까지는 해야한다. N = 15, M = 3이므로
		// N - M의 인덱스까지는 시작점으로서 가능하니
		// int index = 0 ; index < N - M + 1; index++해야한다.

		for (int i = 0; i < N - M + 1; i++) {
			boolean isOk = true;
			for (int j = 0; j < M; j++) {
				if(t.charAt(i + j) != p.charAt(j)) {
					isOk = false;
					break;
				}
			}//패턴 검사 for문
			
			if(isOk) {
				//찾앗다면 인덱스를 리턴
				return i;
			}

		} // 시작점을 위한 for문

		return M;

	}
}
