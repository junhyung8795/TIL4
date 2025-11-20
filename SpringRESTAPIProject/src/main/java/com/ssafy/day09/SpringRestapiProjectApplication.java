package com.ssafy.day09;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
class Employee{
	private int id;
	private String name;
	private String position;
	private String department;
}


//@SpringBootApplication
public class SpringRestapiProjectApplication {

	public static void main(String[] args) throws JsonProcessingException {
//		SpringApplication.run(SpringRestapiProjectApplication.class, args);
		//ObjectMapper객체를 통해서 변환을 진행함.
		ObjectMapper objectMapper = new ObjectMapper();
		
		//Jackson 라이브러리를 통해서 `JAVA`객체를 JSON문자열로 변환해보는걸 해보자
		Employee employee = new Employee(1001, "홍길동", "팀장", "운영");
		String jsonData = objectMapper.writeValueAsString(employee);//이 메서드를 통해서 JSON형태의 문자열을 만들 수 있다.
		
		System.out.println(employee);
		System.out.println(jsonData);
		
		
		//'JSON'문자열을 JAVA객체로 변환
		String rawData = "{\"id\" : 1002 , \"name\" : \"준형\", \"position\": \"공격수\", \"department\":\"집\"}";
		Employee employee2 = objectMapper.readValue(rawData, Employee.class);
		System.out.println(employee2);
	}

}
