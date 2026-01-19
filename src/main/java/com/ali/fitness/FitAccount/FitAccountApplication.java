package com.ali.fitness.FitAccount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class FitAccountApplication {

	 static void main(String[] args) {
		SpringApplication.run(FitAccountApplication.class, args);
	}


}
