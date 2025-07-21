
import java.io.IOException;
import java.util.Scanner;
public class IOStreamTest {
	public static void main(String[] args) throws IOException {
		//출력 스트림 System.in 메서드들
		//1. println 메서드: 입력값을 화면 내에 출력해주는 메서드 (줄바꿈)
		System.out.println("안녕하세요 좋은 오후입니다.");
		System.out.println("날이 덥죠?.");
		System.out.println("");

		//2. print 메서드:        // (줅바꿈 없음) \n을 넣으면 줄바꿈 가능
		System.out.print("안녕하세요 좋은 오후입니다.");
		System.out.print("날이 덥죠?.");
		System.out.print("");
		
		//3. printf 메서드: 우리가 원하는 서식을 지정해서 출력
		// 특수문자를 통해서 개행(\n)
		System.out.printf("원하는 데이터: %d \n", 100);
		System.out.printf("원하는 데이터: %c \n", 100);
		
		//System.out.printf("원하는 데이터: %d \n", 'A');
		System.out.printf("원하는 데이터: %c \n", 'a');
			
		//자료형 크기만 다르지 같은 값이다.
		//아스키코드 상으로 숫자 97은 'a'로 저장돼잇다.
		System.out.println('a' == 97);
		
		//아래 두개는 같다.
//		char cr = 'a';
//		char cr2 = 97;
		//그리고 0이라는 문자는 아스키코드 48이라는 숫자에 대응된다.
		//0이라는 문자를 찍고 싶으면 char c = 48; 이렇게해야한다.
		
		//'7'을 입력 받았을때 값출력하는 상황
		char ch2 = '7';
		System.out.println(0 + '7');//이건 55가 된다.
		//문자와 숫자를 더하면 숫자가 더 큰 자료형이라 작은 자료형은 큰 자료형으로 암묵적 형변환을 한다. 
		
		int digit = ch2 = 48; // '0'에 해당하는 아스키코드 48
		System.out.println(ch2); // 7출력됨.
		
		System.out.println('d' + 0 + 'd');
		System.out.println(100 + 1.0);
		System.out.println(100 / 3.0);
		System.out.println(100 / 3);
		System.out.println('d' / 3);
		System.out.println(0.1 + 0.2 == 0.3);
		System.out.println(0.1 + 0.2);
		System.out.println(0.3);
		//0.1 + 0.2와 0.3이 다른 이유는 컴퓨터는 실수를 저장할때 근사치를 저장하기 때문
		//한정된 메모리 공간안에 0.1을 기록한다고 한다면
		//0.1을 2로 곱하고 나머지를 기록해야하는데, 이 나머지들이 끝이없다.
		//그래서 컴퓨터에 실제로 0.1을 정확하게 저장할 방법이 없다.
		
		System.out.println(0.2);
		System.out.println(0.1 + 0.1);
		//근사치를 저장하기에 실수형 "연산"을 하면 오차가 쌓이게 된다.
		//0.1의 오차와 0.2의 오차와 합쳐져서 0.3과 멀어지게 된 것.
		
		System.out.println(0.2999999999 < (0.1 + 0.2) && (0.1 + 0.2) <= (0.3000000001));
		//이렇게하면 true가 됨
		
		//문자열과의 연산(암묵적 형변환)
		System.out.println("1000" + 123); // 1000123
		System.out.println('d' + 100 + "300"); //200300
		System.out.println('7' + 7 + "7"); //627
		System.out.println("7" + 7 + '7'); //777
		System.out.println(true + "1" + 1); // true11
		//System.out.println(true + 1 + "1");
		
		System.out.println((int) 3.14); // 명시적으로 정수형 형변환!
		System.out.println("1234"); //정수형으로 바꾸고 싶어도 문자열은 데이터 값이 매우 복잡해서
		//문자열은 참조형이라는 타입으로 저장돼있다. (int)앞에 붙여도 형변환이 안된다.
		System.out.println(Integer.parseInt("1234"));
		System.out.println(Double.parseDouble("1.2323"));
		System.out.println(Float.parseFloat("2.3331"));
		System.out.println(Boolean.parseBoolean("true"));
		
		//키보드로 입력한 내용들을 개행을 할때까지 운영체제 버퍼에 담아두었다가 System.in에 흘러 들어가게 된다.
		//문자들은 2byte짜리다.
		//시스템 인으로 흘러가게 되는 데이터가 1바이트를 기준으로 한덩이리가 통으로 날아오는데,
		//1바이트 단위로 캐릭터로(2바이트)로 변환해주는걸 누가해주나? 이걸 Scanner가 해준다.
		//바이트가 내부적으로 2바이트가 된다. 한글이 "핫"이게 2바이트로 돼있다. Scanner가 한글을 보이게 해주는 셈
		//Scanner의 역할: 표준 입력으로 받은 byte의 형식 데이터를 char형식(2byte)으로 전환!
		// byte단위로만 받기
		//byte byte1 = (byte) System.in.read();
		
		Scanner scanner = new Scanner(System.in);
		//문자열 데이터 한번에 받기
		System.out.println(scanner.next()); //공백 문자에 해당되는 데이터 전까지 문자열을 가져온다. -> 띄어쓰기, tab, newLine전 까지
		System.out.println(scanner.nextLine()); //개행 문자가 들어오기 전까지
		
		
		int a = scanner.nextInt();
		System.out.println(a);
		
		float b = scanner.nextFloat();
		System.out.println(b);
		
		int a1 = scanner.nextInt();
		int b1 = scanner.nextInt();
		
		//a와 b를 합하여 출력해보세요!
		System.out.println(a1 + b1);
	}
}
