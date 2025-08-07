
public class String02_회문 {
	public static void main(String[] args) {
		String str = "다시합창합시다";

		int N = str.length();

		// 1. 뒤집기(반복문)
		char[] arr = new char[N];
		for (int i = 0; i < N; i++) {
			arr[i] = str.charAt(N - 1 - i);
		}
		String str2 = new String(arr);
		System.out.println(str2);

		// 2.StringBuilder
		StringBuilder sb = new StringBuilder();
		sb.append(str).reverse();
		System.out.println(sb);

		// 3. swap
		char[] arr2 = str.toCharArray();
		for (int i = 0; i < N / 2; i++) {
			// swap(i의 증가에 따라/ 폭이 점점 줄어든다)
			char tmp = arr2[i];
			arr2[i] = arr2[N - 1 - i];
			arr2[N - 1 - i] = tmp;
		}
		System.out.println(new String(arr2));
		
		//사실 회문인지만 알고 싶으면 swap에서 했던것 처럼 접근만 하고 swap은 하지말자
		//양끝의 문자를 점점 비교하면서 만약 다른게 있으면 회문이 아니고
		//계속 같다면 회문인 것이다
	}
}
