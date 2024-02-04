package com.dh.creditcard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication (exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
public class CreditCardApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditCardApiApplication.class, args);
	}

}
