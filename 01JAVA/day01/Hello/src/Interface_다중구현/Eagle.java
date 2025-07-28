package Interface_다중구현;


public class Eagle implements Bird{

	@Override
	public void fly() {
		System.out.println("날아다닌다.");
		
	}

	@Override
	public void swim() {
		// TODO Auto-generated method stub
		System.out.println("물속사냥을 한다.");
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("쪼아 먹는다.");
	}

}
