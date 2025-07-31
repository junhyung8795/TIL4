package ThrowsTest01;


public class UserExceptionTest {
	
	public static String[] fruits = {"망고", "수박", "복숭아"};
	
	public static void main(String[] args) {
		try {
			sell("망고");
		} catch (FruitNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//요녀석 입장에서 망고라는 과일이 만약 없다면? ->
		//-> 재정의된 예외가 필요
		//
		sell2("sadas");
	}

	private static void sell(String name) throws FruitNotFoundException {
		//과일 목록을 찾아서 판매해야된다면
		for(int i = 0; i < fruits.length; i++) {
			if(name.equals(fruits[i])) {
				System.out.println("판매 완료");
				fruits[i] = null;//나머지 앞으로 밀착하면 좋으나..안함
				return;
			}
		}
		//return;
		throw new FruitNotFoundException(name);
		
	}
	
	private static void sell2(String name) {
		//과일 목록을 찾아서 판매해야된다면
		for(int i = 0; i < fruits.length; i++) {
			if(name.equals(fruits[i])) {
				System.out.println("판매 완료");
				fruits[i] = null;//나머지 앞으로 밀착하면 좋으나..안함
				return;
			}
		}
		//return;
		throw new FruitNotFoundRuntimeException(name);
		
	}
}
