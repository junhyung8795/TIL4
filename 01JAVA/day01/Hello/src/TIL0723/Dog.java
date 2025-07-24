package TIL0723;

public class Dog {
	String name;
	int age;

	// 기본 생성자가 자동으로 생성
//	public Dog() {
//		
//	} 이놈은 생성자를 따로 클래스내에 만들면 사용할 수 없다. 빈 생성자를 만들고 싶으면 
	//빈 생성자를 만들어 오버로딩하자.
	public Dog() {
		System.out.println("갱애쥐의 기본생성자 변형");
	}

	// 매개변수 추가된 생성자
	//매개변수 이름과 필드 이름이 같을 때. 필드를 구분하기 위해서 사용
	//참조변수로서 현재 인스턴스 자기 자신을 가리킴.
	//static 영역에선 사용 불가
	public Dog(String name, int age) {
		this.age = age;
		this.name = name;
	}
	
	
	
	//this()
	//해당 키워드를 통해 같은 클래스의 다른 생성자 호출가능
	//같은 클래스 내에서만 호출 가능하고
	//반드시 생성자의 첫번째 줄에 위치
	//중복 코드를 제거하거나, 생성자 체인으로 간결하고 유지보수하기 쉬운 코드 작성에 도움
	public Dog(int age) {
		this("뽀삐", age);
	}
	
}
