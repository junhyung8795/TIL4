package test01_GSON;

public class StudentNotFoundException extends Exception{

	public StudentNotFoundException(int studentId) {
		super(studentId + "라는 아이디를 가진 학생은 없습니다.s");
	}
	
}
