package com.example.dominio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class DominioApplication {

	public static void main(String[] args) {
		SpringApplication.run(DominioApplication.class, args);
	}

}
