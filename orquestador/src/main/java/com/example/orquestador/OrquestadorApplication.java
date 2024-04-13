package com.example.orquestador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages= "com.example.orquestador.client")
@SpringBootApplication
public class OrquestadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrquestadorApplication.class, args);
	}

}
