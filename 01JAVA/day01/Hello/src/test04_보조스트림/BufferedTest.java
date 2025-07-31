package test04_보조스트림;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedTest {
	public static void main(String[] args) {
		method1();
		method2();
	}

	// 그냥 입출력
	public static void method1() {
		// 생성자에 File 객체를 넣던지 문자열로 경로를 넣던지
		// try with resources로 try문긑나면 알아서 close

		try (FileReader reader = new FileReader("big_input.txt");
				FileWriter writer = new FileWriter("big_input_copy1.txt")) {
				
			long start = System.nanoTime();
			int c; // 문자 전달 손
			while ((c = reader.read()) != -1) {
				System.out.println(c);
				writer.write(c);
			}
			
			long end = System.nanoTime();
			System.out.println("노드 스트림만 사용한 시간: " + (end - start));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("파일 없음 이슈");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("통로 이슈");
		}
	}

	// 보조를 쓴 입출력
	public static void method2() {
		// 생성자에 File 객체를 넣던지 문자열로 경로를 넣던지
		// try with resources로 try문긑나면 알아서 close

		try (BufferedReader br = new BufferedReader(new FileReader("big_input.txt"));
				BufferedWriter bw = new BufferedWriter (new FileWriter("big_input_copy4.txt"));
		){
			
			int c; // 문자 전달 손
			long start = System.nanoTime();
			
			
			while ((c = br.read()) != -1) {
				System.out.println(c);
				bw.write(c);
				bw.newLine();
				
			}
			
			long end = System.nanoTime();
			System.out.println("노드 스트림에 보조 스트림도 사용한 시간: " + (end - start));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("파일 없음 이슈");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("통로 이슈");
		}
	}
}
