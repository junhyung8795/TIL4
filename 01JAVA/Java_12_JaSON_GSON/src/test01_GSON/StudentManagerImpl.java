package test01_GSON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

//싱글톤 수정
public class StudentManagerImpl implements StudentManager {

	private static final StudentManager sm = new StudentManagerImpl();

	private StudentManagerImpl() {
	}

	private List<Student> studentList = new ArrayList<>();

	private File file = new File("data.student.json");
//	private static final String DELIM = "\t";
	private Gson gson = new Gson();

	public static StudentManager getManager() {
		return sm;
	}

	@Override
	public boolean add(Student student) {
		// TODO Auto-generated method stub
		if (studentList.size() > 100) {
			System.out.println("최대 양 초과");
			return false;
		}
		// 추후 고려 포인트 student 객체는 완벽한가?
		// 유효성 검사 모든 필드가 완벽하게 작성 되어 있는지 유효한지! 등을 체크
		// 모든 필드가 제대로 초기화된 student를 넣게 해야한다.
		studentList.add(student);
		return true;
	}

	@Override
	public List<Student> getAll() {
		// 배열로 했다면
		// 실제 있는 크기만큼 -> 새로운 배열을 생성하고 복사해서 반환한다.
		return studentList;
	}

	@Override
	public Student getStudent(int studentId) {
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getStudentId() == studentId) {
				return studentList.get(i);
			}
		}

//		for(Student st: studentList) {
//			if(st.getStudentId() == studentId)
//				return st;
//		}
		return null;
	}

	@Override
	public List<Student> searchName(String name) {
		List<Student> tmp = new ArrayList<>();
		for (Student st : studentList) {
			if (st.getName().equals(name))
				tmp.add(st);
		}
		return tmp;
	}

	@Override
	public void update(Student student) throws StudentNotFoundException {
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getStudentId() == student.getStudentId()) {
				studentList.set(i, student);
			}
		}
		throw new StudentNotFoundException(student.getStudentId());
	}

	@Override
	public boolean delete(int id) {
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getStudentId() == i) {
				studentList.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public void saveData() {
		// TODO Auto-generated method stub
		// 저장을 한다~ -> 프로그램에서 파일로 내보내는 것
		// 전부 문자니까 Reader를 쓸 수 있다.
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)))) {
			bw.write(gson.toJson(studentList));
			System.out.println("저장 완료");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void loadData() {
		// TODO Auto-generated method stub
		if (file.exists()) {
			try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
				//
				
				
				String line = br.readLine();
				Type studentListType = new TypeToken<ArrayList<Student>>() {}.getType();
				studentList = gson.fromJson(line, studentListType);
				
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}


