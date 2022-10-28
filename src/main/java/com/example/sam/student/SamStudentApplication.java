package com.example.sam.student;

import com.example.sam.student.repository.SamJpaRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = SamJpaRepositoryImpl.class)
public class SamStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SamStudentApplication.class, args);
	}

}
