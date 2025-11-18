package com.ssafy.board.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConfig {
	private static SqlSessionFactory factory;
	
	static {
		//스태틱 블럭. 초기화 나중에 new로 그냥 생성자로 초기화해도된다.
		//factory 건설
		//설정파일 경로
		String resource = "mybatis-config.xml";
		//설정파일을 읽을 inputStream하나 만들어야한다. -> close()
		try(InputStream inputStream = Resources.getResourceAsStream(resource)){
			factory = new SqlSessionFactoryBuilder().build(inputStream);
			System.out.println("공장 건설 성공!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("공장건설 실패!");
		}
		
		
	}
	
	public static SqlSessionFactory getFactory() {
		return factory;
	}
}
