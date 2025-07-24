package TIL0723;

public class PersonTestUsingClass {
	public static void main(String[] args) {
		Person park = new Person();
		park.age = 27;
		park.hobby = "Game";
		park.name = "Park";
		
		park.info();
		park.study(100);
		short s = 20;
		long l = 1000L;
		park.study(s);
		//park.study(l);
		
		Person jang = new Person();
		jang.name = "Jang";
		jang.age = 18;
		jang.hobby = "수다";
		jang.info();
	}
	
	
}
