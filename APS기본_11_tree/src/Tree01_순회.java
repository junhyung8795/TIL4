
public class Tree01_순회 {
	static char[] tree = { '\u0000', 'A', 'B', 'C', 'E', 'F', 'G', '\u0000', '\u0000', 'H', 'I' };
	static int N = tree.length;

	public static void main(String[] args) {
		System.out.println("전위순회");
		preOrder(1);// 1번을 시작으로 순회
	}

	// 전위순회
	public static void preOrder(int v) {
		// v is not null; v가 배열을 벗어나지도 않고 공백 문자도 아니여야한다. 그러면 노드가 잇다는 것이다,
		if (v < N && tree[v] != '\u0000') {
			System.out.println(tree[v]);// 방문처리
			// 왼자탐색
			preOrder(v * 2);
			// 오른자 탐색
			preOrder(v * 2 + 1);
		}
	}

	// 중위순회
	public static void inOrder(int v) {
		// v is not null; v가 배열을 벗어나지도 않고 공백 문자도 아니여야한다. 그러면 노드가 잇다는 것이다,
		if (v < N && tree[v] != '\u0000') {
			
			// 왼자탐색
			inOrder(v * 2);
			System.out.println(tree[v]);// 방문처리
			// 오른자 탐색
			inOrder(v * 2 + 1);
		}
	}
	
	// 후위순회
	public static void postOrder(int v) {
		// v is not null; v가 배열을 벗어나지도 않고 공백 문자도 아니여야한다. 그러면 노드가 잇다는 것이다,
		if (v < N && tree[v] != '\u0000') {
			
			// 왼자탐색
			postOrder(v * 2);
			
			// 오른자 탐색
			postOrder(v * 2 + 1);
			System.out.println(tree[v]);// 방문처리
		}
	}
}
