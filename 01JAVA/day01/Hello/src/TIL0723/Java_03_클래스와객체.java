package TIL0723;

import java.util.Random;

public class Java_03_클래스와객체 {
	public static void main(String[] args) {
		System.out.println("아침루틴");
		
		
//		System.out.println("학원으로 대중교통으로 이동");
		이동("학원", "버스");
		
		//숙제를 한다!. 그런데 숙제는 그날 할게 있는 경우에만 한다!
//		boolean 숙제 = 교육();
		if(교육()) {
			System.out.println("숙제를 한다.");
		}
			
			
//		System.out.println("집으로 대중교통으로 이동");
		이동("집", "기차");
		
		
		
		System.out.println("잠을 잔다.");
	}
	
	
	//함수
//	public static void 교육() {
//		System.out.println("수업듣기");
//	}
	
	
	//반환
	public static boolean 교육() {
		System.out.println("수업듣기");
		return new Random().nextBoolean();
		
	}
	
	
	
	public static void 이동(String 장소, String 교통수단) {
		System.out.println(장소 + "(으)로 " + 교통수단+ "를(을) 이용하여 이동");
	}
}
