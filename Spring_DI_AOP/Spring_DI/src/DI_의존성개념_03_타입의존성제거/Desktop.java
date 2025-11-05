package DI_의존성개념_03_타입의존성제거;

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
