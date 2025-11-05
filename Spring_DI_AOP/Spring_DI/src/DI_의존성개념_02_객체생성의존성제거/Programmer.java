package DI_의존성개념_02_객체생성의존성제거;

public class Programmer {
	private String name;
	private int age;
	//핵심
	
	private Desktop desktop;
	
	
	
	//생성한다 -> 고용한다
	//객체생성 의존성을 제거를 하겠다.
	public Programmer(Desktop desktop) {
		//전에는 프로그래머를 생성하면 항상 데스크탑을 생성해줬다.
		this.desktop = desktop;//이전과 달리 이미 있는 데스크탑을 넣어준다. -> 객체 생성의존성을 제거함.
		
	}
	
	public void coding() {
		System.out.println(desktop.getInfo() + " 으로 개발을 합니다.");
	}
}
