package day08;

import java.io.File;

public class FileTest {
	public static void main(String[] args) {
		File f = new File("cat.jpg");
		System.out.println(f.exists());
		
		System.out.println(f.isFile());
		System.out.println(f.isDirectory());
		System.out.println(f.isAbsolute());
		System.out.println(f.getAbsolutePath());
		System.out.println("-----------");
		
		File bin = new File("bin");
		System.out.println(bin.isDirectory());
		System.out.println(bin.exists());
		
		//없는 폴더를 지정
		File folder = new File("static/2025/07/31"); // static/2025/07/31은 안됨
		//mkdir은 부모 디렉토리가 있는 경우에만 생성할 수 있어서 new File("static");로해야됨
		System.out.println(folder.exists());
		
		//폴더 생성 mkdir vs mkdirs
//		System.out.println(folder.mkdir());
		
//		System.out.println(folder.mkdirs());/mkdirs은 부모 폴더 없어도 다 만들어줌
		
		
	}
}
