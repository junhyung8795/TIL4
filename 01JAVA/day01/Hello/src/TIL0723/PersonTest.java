package TIL0723;

public class PersonTest {
	public static void main(String[] args) {
		// 사람의 정보를 관리하자!

		String name1 = "park";
		int age1 = 27;
		String hobby = "game";

		String name2 = "Kim";
		int age2 = 26;
		String hobby2 = "lol";

		// 100명이면 너무 많이 써야한다. ㄷ..

		// 배열
		int size = 100;
		String[] names = new String[size];
		int[] ages = new int[size];
		String[] hobbies = new String[size];

		// 몇번 인덱스에 어떤 정보가 입력되는지 사람이 일일이 다 알고
		// 있어야 한다.
		//그리고 names ages hobbies는 각각의 배열로 따로 존재함
		//관계가 코드적으로 설정돼 있진 않음. 하나의 정보로 묶어야하는데 이게 클래스
		names[0] = name1;
		names[1] = name2;
		ages[0] = 27;
		ages[1] = 26;
		hobbies[0] = "game";
		hobbies[1] = "lol";
	}
}
