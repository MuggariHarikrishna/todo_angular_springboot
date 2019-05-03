package com.todo.tododemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.bo","com.controllers","com.dao","com.service"})
public class TodoDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoDemoApplication.class, args);
	}
}
