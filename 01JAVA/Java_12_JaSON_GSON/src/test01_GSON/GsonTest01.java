package test01_GSON;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GsonTest01 {
	//GSON 등록해야 사용 ㄱ능
	//1 직접 추가 ()jar를 이용해서 추가
	//2 maven pjt 등록하는 방법
	public static void main(String[] args) {
		Gson gson = new Gson();
		
		Student st = new Student(0, "양띵균", "컴퓨터공학", "자바비전공");
		System.out.println(st);
		
		String stJson = gson.toJson(st);
		System.out.println(stJson);
		
		Student st2 = gson.fromJson(stJson, Student.class);
		System.out.println(st2);
		
		Student[] sArr = new Student[4];
		sArr[0] = st;
		sArr[1] = st2;
		
		List<Student> sList = new ArrayList<>();
		sList.add(st);
		sList.add(st2);
		
		//객체리스트를 json으로 변환
		String listStr = gson.toJson(sList);
		System.out.println(listStr);
		
		//json을 객체리스트로 변환
		
		Type studentListType = new TypeToken<ArrayList<Student>>() {}.getType();
		ArrayList<Student> sList2 = gson.fromJson(listStr, studentListType);
		
		for(Student student: sList2) {
			System.out.println(student);
		}
		
		
		
	}
}
