package com.colocation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ColocationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ColocationApplication.class, args);
		System.out.println("Works");
	}

}
