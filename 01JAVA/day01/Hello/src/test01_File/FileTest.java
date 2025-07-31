package test01_File;

import java.io.File;

public class FileTest {
	public static void main(String[] args) {
		//File 클래스: 파일이나 폴더 관리하기 위한 클래스
		File file = new File("dog.jpg");
		
		System.out.println(file.exists());
		System.out.println(file.isFile());
		System.out.println(file.isDirectory());
		
		System.out.println(file.isAbsolute());
		System.out.println(file.getAbsolutePath());
		
		//메모리상에서 사용할 수 있게끔 인스턴스를 생성한거지 실제 컴퓨터에 파일이나 폴더가 생긴게 아니다.
		File src = new File("src");
		
		File folder = new File("folder");
		//존재하냐고 물어보면 없다고 나온다.
		System.out.println(folder.exists());
		folder.mkdir();
		System.out.println(folder.exists());
	}
}
