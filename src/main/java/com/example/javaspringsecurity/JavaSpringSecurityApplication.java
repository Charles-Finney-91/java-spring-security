package com.example.javaspringsecurity;

import com.example.javaspringsecurity.repositories.MyUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaSpringSecurityApplication {

	@Autowired
	MyUserRepo myUserRepo;

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringSecurityApplication.class, args);
	}

}
