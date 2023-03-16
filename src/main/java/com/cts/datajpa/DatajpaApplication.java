package com.cts.datajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cts.datajpa.service.Menu;

@SpringBootApplication
public class DatajpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatajpaApplication.class, args);
		AnnotationConfigApplicationContext an = new AnnotationConfigApplicationContext();
		an.scan("com");
		an.refresh();
		Menu pc = an.getBean(Menu.class);
		pc.createData();
		pc.displayMenu();
	}

}
