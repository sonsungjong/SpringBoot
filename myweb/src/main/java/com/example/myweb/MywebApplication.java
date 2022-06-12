package com.example.myweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})		// 데이터베이스 무시
public class MywebApplication {

	public static void main(String[] args) {
		SpringApplication.run(MywebApplication.class, args);
		System.out.println("웹 실행 완료!");
	}

}

// .controller

// Port 8080 was already in use.
// cmd -> netstat -ano -> TCP 0.0.0.0:8080의 PID를 찾는다 -> taskkill /f /pid 번호

// localhost:8080
