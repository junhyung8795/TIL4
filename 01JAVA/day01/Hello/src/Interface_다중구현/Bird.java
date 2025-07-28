package Interface_다중구현;

//인터페이스끼리의 상속!
//인터페이스가 다른 인터페이스를 구현하지는 않기 때문에 extends
public interface Bird extends Flyable, Swimmable{
	void eat();
}
