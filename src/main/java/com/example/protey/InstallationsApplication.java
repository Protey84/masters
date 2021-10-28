package com.example.protey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class InstallationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstallationsApplication.class, args);
	}

}
