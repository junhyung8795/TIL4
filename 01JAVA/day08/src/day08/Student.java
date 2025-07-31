package day08;

import java.io.Serializable;

//설계도 -> 조금만 더! -> 파일 입출력을 위한 Serializable구현
public class Student implements Serializable, Comparable<Student>{
	
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getTrack() {
		return track;
	}

	public void setTrack(String track) {
		this.track = track;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", major=" + major + ", track=" + track + "]";
	}

	private int studentId;//고유한 학번이니 이걸 기준으로 정렬
	private String name;
	private String major;
	private String track;
	
	public Student() {
	}

	public Student(int studentId, String name, String major, String track) {
		super(); //이거 누구야! -> Object 기본 생성자 호출
		this.studentId = studentId;
		this.name = name;
		this.major = major;
		this.track = track;
	}

	@Override
	public int compareTo(Student o) {
		//음  0  양
		return this.studentId - o.studentId;
	}
	
	
	
	
	
}
