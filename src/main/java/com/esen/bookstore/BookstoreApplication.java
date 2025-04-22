package com.esen.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookstoreApplication {

	//http://localhost:9090/h2-console
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

}
