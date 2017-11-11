package com.vzard.educms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication
public class EduCmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EduCmsApplication.class, args);
	}
}
