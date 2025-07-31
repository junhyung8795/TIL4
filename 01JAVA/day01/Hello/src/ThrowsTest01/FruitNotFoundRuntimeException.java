package ThrowsTest01;

public class FruitNotFoundRuntimeException extends RuntimeException{
	public FruitNotFoundRuntimeException(String name) {
		super(name + "에 해당하는 과일은 없다!");
	}
}
