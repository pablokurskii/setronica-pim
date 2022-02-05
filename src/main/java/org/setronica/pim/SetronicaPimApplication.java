package org.setronica.pim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SetronicaPimApplication {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "setronica");
		SpringApplication.run(SetronicaPimApplication.class, args);
	}

}