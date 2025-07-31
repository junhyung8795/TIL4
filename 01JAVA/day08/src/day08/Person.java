package day08;

import java.io.Serializable;

//직렬 -> 객체를 파일로 저장 ex) person.dat
//PErson안의 필드를 수정하면? 다른 버전이니까 이때에는 UID도 변경해줘야한다.
//그렇지 않으면 만약 새로운 필드가 추가됐을 때 null로 만들어 버릴 경우가 있다.
//버전이 바뀌었다면 역직렬화 자체를 막는것이 좋다
public class Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2989230925804361087L;
	/**
	 * 
	 */
	public String name;
	public int age;
	public String className;
	
	public Person(String name, int age, String className) {
		super();
		this.name = name;
		this.age = age;
		this.className = className;
	}
	
	
}
