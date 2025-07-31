package day08;

import java.util.List;

public interface StudentManager {
	
	public abstract boolean add(Student student);
	public abstract List<Student> getAll();
	public abstract Student getStudent(int studentId);
	public abstract List<Student> searchName(String name);
	public abstract void update (Student student)throws StudentNotFoundException;
	public abstract boolean delete(int id);
	
	//저장
	public abstract void saveData();
	
	//불러오기
	public abstract void loadData();
	
}
