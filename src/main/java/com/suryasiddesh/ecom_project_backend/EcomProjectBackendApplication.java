package com.suryasiddesh.ecom_project_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin("*")
public class EcomProjectBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomProjectBackendApplication.class, args);


	}

}
