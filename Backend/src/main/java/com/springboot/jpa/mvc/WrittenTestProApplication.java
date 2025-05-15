package com.springboot.jpa.mvc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WrittenTestProApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(WrittenTestProApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.getClass().getSuperclass().getSimpleName() + " is Started.....");
	}
}
