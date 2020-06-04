package com.ps.formacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class FormacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormacionApplication.class, args);
	}

}
