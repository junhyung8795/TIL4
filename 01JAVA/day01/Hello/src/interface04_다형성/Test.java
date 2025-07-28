package interface04_다형성;

public class Test {
	public static void main(String[] args) {
		KFoodChef k = new KFoodChef();

		k.cook();

		// 참조 타입으로 Chef 사용가능하다 -> 다형성 때문에
		Chef chef = new KFoodChef();
		chef.cook();// 동적 바인딩

		// 익명 클래스 문법으로 1회한정 구현 가능
		Chef chef2 = new Chef() {

			@Override
			public void cook() {
				System.out.println("익명클래스 쿡!");

			}

		};

		chef2.cook();
	}
}
