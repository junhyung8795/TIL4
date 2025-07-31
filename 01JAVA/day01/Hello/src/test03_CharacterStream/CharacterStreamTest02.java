
package test03_CharacterStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStreamTest02 {
	public static void main(String[] args) {
		// 생성자에 File 객체를 넣던지 문자열로 경로를 넣던지
		//try with resources로 try문긑나면 알아서 close
		
		 
		try (FileReader reader = new FileReader("big_input.txt");
				FileWriter writer = new FileWriter("big_input_copy1.txt")){
			
			int c; //문자 전달 손
			char[] buffer = new char[100];//손이 아닌 바구니!
			
			while((c = reader.read(buffer)) != -1) {
				System.out.println(c);
				writer.write(buffer, 0, c);
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
