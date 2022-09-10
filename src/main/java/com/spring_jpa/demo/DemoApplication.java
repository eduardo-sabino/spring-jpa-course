package com.spring_jpa.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepository studentRepository) {
		return args -> {
			Name name = new Name("John", "Doe");
			Student student = new Student(
				name,
				"john@gmail.com",

				19
			);
			
			studentRepository.save(student);
		};
	};
}
