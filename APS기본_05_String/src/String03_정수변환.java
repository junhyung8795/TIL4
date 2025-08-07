
public class String03_정수변환 {
	public static void main(String[] args) {
		String strNum = "123456";
		//문자열을 정수로 바꾸기 위해서는
		int num = Integer.parseInt(strNum);
		System.out.println(num);
		
		System.out.println(atoi(strNum));
	}
	
	//str은 아주 깔금한 형태의 숫자만 들어온다. 예로 "123456"
	//음수가 들어오거나 실수가 들어오는 경우도 고려하려면 어떻게해야할까?
	//혹은 거꾸로 출력하려면?
	public static int atoi(String str) {
		int N = str.length();
		int num = 0; // 반환할 int자료형
		
		//1 2 3 4 5 6
//		for(int i = 0; i < N; i++) {
//			char c= str.charAt(i); // '1', '2', '3', '4', '5', '6' 하나씩 들어온다.
//			
//			num = (num * 10) + (c - 48);//0이라는 문자는 아스키 코드 48이니 
//			//1은 49.그런데 여기서 -48을 빼면 1의 아스키 코드가 49여도 숫자1이 나온다!
//			//혹은 (num * 10) + (c - '0')
//		}
//		
		
		for(int i = 0; i < N; i++) {
			char c= str.charAt(i); // '1', '2', '3', '4', '5', '6' 하나씩 들어온다.
			
			if(c >= '0' && c <='9') {
				(num * 10) + (c - '0')
			}
//			num = (num * 10) + (c - 48);//0이라는 문자는 아스키 코드 48이니 
			//1은 49.그런데 여기서 -48을 빼면 1의 아스키 코드가 49여도 숫자1이 나온다!
			//혹은 (num * 10) + (c - '0')
		}
		return num;
		
	}
	
	//정수 -> 문자열로(마음의 숙제)
	public static String itoa(int num) {
		String strNum = num + "";
		
		return strNum;
	}
	
	
	
	
	
	
	
	
}
