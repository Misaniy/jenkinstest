package com.example.test0104;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.test0104.mapper")
public class Test0104Application {

	public static void main(String[] args) {
		SpringApplication.run(Test0104Application.class, args);
	}
}
