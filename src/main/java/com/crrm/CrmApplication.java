package com.crrm;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmApplication.class, args);
	}

//	@Bean
//	public ModelMapper getMapper(){
//		return new ModelMapper();
//	}
	// always work but i am Spreate class creted configclass best practice;
}
