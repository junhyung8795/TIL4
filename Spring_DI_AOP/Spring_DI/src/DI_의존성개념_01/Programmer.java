package DI_의존성개념_01;

public class Programmer {
	private String name;
	private int age;
	//핵심
	
	private Desktop desktop;
	
	
	
	//생성한다 -> 고용한다
	public Programmer() {
		this.desktop = new Desktop();
	}
	
	public void coding() {
		System.out.println(desktop.getInfo() + " 으로 개발을 합니다.");
	}
}
