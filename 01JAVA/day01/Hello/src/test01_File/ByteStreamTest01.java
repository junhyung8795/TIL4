package test01_File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamTest01 {
	public static void main(String[] args) {
		// 생성자에 File 객체를 넣던지 문자열로 경로를 넣던지
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis= new FileInputStream("dog.jpg");
			fos= new FileOutputStream("dog-copy");
			int b; //byte를 담을 손
			
			while((b = fis.read()) != -1) {
				fos.write(b);
			}
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("파일 없음 이슈");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("통로 이슈");
		} 
		//통로를 닫아야한다!
	}
}
