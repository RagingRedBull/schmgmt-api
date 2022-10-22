package com.example.sam;

import com.example.sam.repository.SamJpaRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = SamJpaRepositoryImpl.class)
public class SamApplication {

	public static void main(String[] args) {
		SpringApplication.run(SamApplication.class, args);
	}

}
