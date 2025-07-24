package TIL0723;

public class DogTest {
	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.name = "aaa";
		dog.age = 18;
		
		Dog dog3 = new Dog();
		Dog dog2 = new Dog("asdasd", 89);
		
		Dog dog4 = new Dog(10);
		System.out.println(dog4.name);
		
	}
}
