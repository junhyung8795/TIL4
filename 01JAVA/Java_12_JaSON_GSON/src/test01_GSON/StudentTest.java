package test01_GSON;

import java.util.Scanner;

public class StudentTest {
	public static void main(String[] args) {
		StudentManager mgr = StudentManagerImpl.getManager();
		Scanner sc = new Scanner(System.in);
		
		mgr.add(new Student(1, "did", "zja", "java"));
		mgr.saveData();
		
		int sel;
		do {
			System.out.println("-------------");
			System.out.println("1. 학생등록");
			System.out.println("2. 학생 전체 조회");
			System.out.println("3. 학생 수정");
			
			
			sel = sc.nextInt();
			System.out.println("------------");
			if(sel == 1) {
				System.out.println("학생을 등록하겠습니다.");
				System.out.println("학번: ");
				int studentId = sc.nextInt();
				System.out.println("이름: ");
				String name = sc.next();
				System.out.println("전공: ");
				String major = sc.next();
				System.out.println("트랙: ");
				String track = sc.next();
				mgr.add(new Student(studentId, name,  major, track));
				
			} else if(sel == 2) {
				System.out.println("전체 조회");
			} else if(sel ==3) {
				
			}
		}while(sel != 0);
	}
}
