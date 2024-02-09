package com.example.javaspringsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestJavaSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.from(JavaSpringSecurityApplication::main).with(TestJavaSpringSecurityApplication.class).run(args);
	}

}
