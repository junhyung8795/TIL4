package DI_의존성개념_04_의존성주입;

public class Desktop implements Computer{

	// TODO Auto-generated method stub
	private String CPU;
	private String RAM;
	private String SSD;
	private String GPU;

	public String getInfo() {
		return "데스크톱";
	}

}
