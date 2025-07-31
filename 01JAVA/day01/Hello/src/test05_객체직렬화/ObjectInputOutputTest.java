package test05_객체직렬화;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectInputOutputTest {
	public static void main(String[] args) {
		//현재 메모리상에 존재
		Person p = new Person("Kim", 40);
		
		//실제 파일로 저장
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.txt"));)
		{
			oos.writeObject(p);
		} catch(IOException e){
			e.printStackTrace();
		}
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.txt"));)
		{
			Object obj = ois.readObject();
			System.out.println(obj);
		} catch(IOException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
}
