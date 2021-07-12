package com.example.promain;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.promain.mapper")
@SpringBootApplication
public class PromainApplication {

	public static void main(String[] args) {
		SpringApplication.run(PromainApplication.class, args);
	}
}
