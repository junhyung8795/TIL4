package day08;

public class Test {
	public static void main(String[] args) {
		StudentManagerImpl mgr =  StudentManagerImpl.getManager();
		Student st = new Student(5
				, "sad", "sadad", "asas");
		System.out.println(st);
		
		mgr.add(st);
		mgr.add(st);
		mgr.add(st);
		System.out.println(mgr.getAll());
		
		Student st6 = new Student(1, "준형", "기게", "자바 비전공");
		st6.setStudentId(5);
		
		try {
			mgr.update(st6);
		}catch (StudentNotFoundException e){
			System.out.println(e.getStackTrace());
		}
		
		mgr.delete(5);
		mgr.saveData();
		
	}
}

